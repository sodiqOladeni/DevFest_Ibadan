package dev.hackwithsodiq.devfestibadan.view.speaker

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import dev.hackwithsodiq.devfestibadan.data.AppDao
import javax.inject.Inject

class SpeakerViewModel @Inject constructor(private val dao: AppDao, private val firestore: FirebaseFirestore): ViewModel() {
    // TODO: Implement the ViewModel
}