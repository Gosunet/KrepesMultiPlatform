package com.gosunet.krepesmultiplatform.shared.data

import kotlinx.serialization.Serializable

@Serializable
data class Crepe(
    val name: String,
    val description: String,
    val url: String,
    val rate: String,
    val image: String
)
