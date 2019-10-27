package dev.hackwithsodiq.devfestibadan.view.team

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import dev.hackwithsodiq.devfestibadan.data.AppDao
import javax.inject.Inject

class TeamViewModel @Inject constructor(private val dao: AppDao, private val firestore: FirebaseFirestore): ViewModel() {
    // TODO: Implement the ViewModel
}
