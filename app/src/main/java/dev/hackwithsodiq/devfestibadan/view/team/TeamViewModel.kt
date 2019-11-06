package dev.hackwithsodiq.devfestibadan.view.team

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.hackwithsodiq.devfestibadan.model.Team
import javax.inject.Inject
import org.json.JSONException
import org.json.JSONObject



class TeamViewModel @Inject constructor() : ViewModel() {
    private var _allTeams = MutableLiveData<List<Team>>()
    val allTeams: LiveData<List<Team>>
        get() = _allTeams

    fun loadTeamAsset(assetJson:String){
        try {
            val obj = JSONObject(assetJson)
            val teamArray = obj.getJSONArray("team")
            val theTeams = ArrayList<Team>()

            for (i in 0 until teamArray.length()) {
                val teamValue = teamArray.getJSONObject(i)
                val name = teamValue.getString("name")
                val role = teamValue.getString("role")
                val imageLink = teamValue.getString("imageLink")
                val position = teamValue.getInt("position")
                val twitter = teamValue.getString("twitter")
                val webLink = teamValue.getString("webLink")
                theTeams.add(Team(name, role, imageLink, position, twitter, webLink))
            }
//            Log.v("Teams", "The real ==> "+theTeams)
            _allTeams.value = theTeams.sortedBy { it.position }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }
}
