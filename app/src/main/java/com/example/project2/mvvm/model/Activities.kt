package com.example.project2.mvvm.model

import com.squareup.moshi.Json

data class Activities (
    @Json(name = "Invasions") val invasions : List<Invasion>,
    @Json(name = "Sorties" ) val sorties : List<Sortie>
)