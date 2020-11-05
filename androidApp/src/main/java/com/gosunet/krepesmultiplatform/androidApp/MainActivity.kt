package com.gosunet.krepesmultiplatform.androidApp

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gosunet.krepesmultiplatform.shared.Greeting
import com.gosunet.krepesmultiplatform.shared.data.CrepesRepository
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    private val crepesRepository: CrepesRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainScope().launch {
            val crepes = crepesRepository.getCrepes()
            Log.i("crepes", crepes)
        }

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()
    }
}
