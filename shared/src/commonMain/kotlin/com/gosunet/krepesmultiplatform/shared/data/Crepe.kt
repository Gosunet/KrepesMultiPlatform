package com.gosunet.krepesmultiplatform.shared.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Crepe(
    var name: String,
    var description: String,
    val url: String? = null,
    val rate: String? = null,
    val image: String = "https://assets.afcdn.com/recipe/20200227/108298_w648h414c1cx2736cy1824.jpg",
    val author: String? = null,
    @SerialName("cooking_time") val cookingTime: String? = null,
    @SerialName("prep_time") val prepTime: String? = null,
    @SerialName("total_time") val totalTime: String? = null,
    val difficulty: String? = null,
    val pricing: String? = null,
    @SerialName("people_number") val peopleNumber: String? = null,
    val tags: List<String>? = null,
    val ingredients: List<String>? = null,
    val steps: List<String>? = null,
    @SerialName("author_tip") val authorTip: String? = null
)
