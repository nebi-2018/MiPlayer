package com.example.myapplication.Data.Entity.remote

import com.example.myapplication.Data.Entity.Song
import com.example.myapplication.other.Constants.SONG_COLLECTION
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class MDatabase {

    private val firestore = FirebaseFirestore.getInstance()
    private val songCollection = firestore.collection(SONG_COLLECTION)

    suspend fun getAllSongs():List<Song>{
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        }catch (e:Exception){
            emptyList()
        }
    }
}