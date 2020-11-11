package com.gosunet.krepesmultiplatform.shared.data

import kotlinx.serialization.Serializable

@Serializable
data class Crepe(
    var name: String,
    var description: String,
    val url: String,
    val rate: String,
    val image: String
)
