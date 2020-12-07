package com.gosunet.krepesmultiplatform.androidApp.features.shared

import androidx.compose.foundation.layout.preferredSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieAnimationSpec
import com.gosunet.krepesmultiplatform.androidApp.R

@Composable
fun Loader() {
    val animationSpec = remember { LottieAnimationSpec.RawRes(R.raw.rounded_loading_circle) }
    LottieAnimation(
        animationSpec
    )
}
