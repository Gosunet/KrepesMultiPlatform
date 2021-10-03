package com.gosunet.krepesmultiplatform.androidApp.features.shared

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.gosunet.krepesmultiplatform.androidApp.R

@Composable
fun Loader() {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.rounded_loading_circle)
    )
    LottieAnimation(
        composition
    )
}
