package com.example.project2.mvvm.model

import com.squareup.moshi.Json

data class Invasion (
    @Json(name="Node") val node: String,
    @Json(name="DefenderFaction") val defenderFaction: String,
    @Json(name="Faction") val faction: String
)