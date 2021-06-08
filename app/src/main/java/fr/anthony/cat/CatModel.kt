package fr.anthony.cat

import android.net.Uri

class CatModel(
    val name: String = "Goutière",
    val description: String = "Petite description",
    val imageUrl: String = "http://api.cat.jpg",
    var liked: Boolean = false
)
