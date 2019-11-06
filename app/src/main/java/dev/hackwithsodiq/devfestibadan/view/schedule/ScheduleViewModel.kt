package dev.hackwithsodiq.devfestibadan.view.schedule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import dev.hackwithsodiq.devfestibadan.data.AppDao
import javax.inject.Inject

class ScheduleViewModel @Inject constructor(private val dao: AppDao, private val firestore: FirebaseFirestore): ViewModel() {
    val allSchedules = dao.allSchedules()
    private val _index = MutableLiveData<Int>()

    fun setIndex(index: Int) {
        _index.value = index
    }
}