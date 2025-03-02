package com.example.project2.mvvm.model

import com.squareup.moshi.Json

data class Sortie (
    @Json(name = "Expiry")val time : Date, // time when sortie ends
    @Json(name = "Boss") val boss: String,
    @Json(name = "Variants") val variants: List<SortieVariant>
)

data class SortieVariant (
    @Json(name = "node") val node: String,
    @Json(name = "missionType") val missionType: String,
    @Json(name = "modifierType")val modifierType: String,
    @Json(name = "tileset")val tileset: String,
)

data class Date(
    @Json(name = "\$date") val date: DateLong
)

data class DateLong(
    @Json(name = "\$numberLong") val numberLong: String
)