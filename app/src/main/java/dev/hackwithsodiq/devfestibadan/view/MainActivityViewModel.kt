package dev.hackwithsodiq.devfestibadan.view

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.*
import dev.hackwithsodiq.devfestibadan.data.AppDao
import dev.hackwithsodiq.devfestibadan.model.Schedule
import kotlinx.coroutines.*
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val dao: AppDao,
    private val firestore: FirebaseFirestore
) : ViewModel(), EventListener<QuerySnapshot> {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private val snapshots = ArrayList<DocumentSnapshot>()
    private var mQuery: Query? = null
    var registration: ListenerRegistration? = null

    init {
        val query = firestore.collection("All_Schedules")
        setQuery(query)
    }

    private fun setQuery(query: Query) {
        // Stop listening
        stopListening()
        // Clear existing data
        snapshots.clear()
        // Listen to new query
        this.mQuery = query
        startListening()
    }

    private fun stopListening() {
        registration?.remove()
        registration = null
        snapshots.clear()
    }

    private fun startListening() {
        if (mQuery != null && registration == null) {
            registration = mQuery?.addSnapshotListener(this)
        }
    }

    override fun onEvent(querySnapshot: QuerySnapshot?, e: FirebaseFirestoreException?) {
        if (e != null) {
            return
        }

        for (change in querySnapshot?.documentChanges!!) {
            val snapshot = change.document
            when (change.type) {
                DocumentChange.Type.ADDED -> {
                    uiScope.launch {
                        saveScheduleInDb(snapshot.toObject(Schedule::class.java))
                    }
                }
                DocumentChange.Type.MODIFIED -> {
                    uiScope.launch {
                        updateRequestChangesInDb(snapshot.toObject(Schedule::class.java))
                    }
                }
                DocumentChange.Type.REMOVED -> {
                    uiScope.launch {
                        deleteRequestChangesInDb(snapshot.toObject(Schedule::class.java))
                    }
                }
            }
        }
    }

    private suspend fun saveScheduleInDb(schedule: Schedule) {
        withContext(Dispatchers.IO) {
            dao.saveSchedule(schedule)
        }
    }

    private suspend fun updateRequestChangesInDb(schedule: Schedule) {
        withContext(Dispatchers.IO) {
            dao.updateSchedule(schedule)
        }
    }

    private suspend fun deleteRequestChangesInDb(schedule: Schedule) {
        withContext(Dispatchers.IO) {
            dao.deleteSchedule(schedule)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
        stopListening()
    }
}