package com.example.tugas_uas_21411024

import com.google.firebase.database.Exclude

data class Movie(
    var name:String? = null,
    var imageUrl:String? = null,
    var description:String? = null,
    @get:Exclude
    @set:Exclude
    var key:String? = null
)