package com.gosunet.krepesmultiplatform.androidApp.features.crepeslist

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.gosunet.krepesmultiplatform.shared.data.Crepe

class CrepesProvider : PreviewParameterProvider<Crepe> {
    override val values: Sequence<Crepe>
        get() = sequenceOf(
            Crepe("Crepe 1", "Bla bla", "crepe.com", "1.1", "image.com"),
            Crepe("Crepe 2", "Bla bla", "crepe.com", "1.1", "image.com")
        )
}
