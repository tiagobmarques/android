package com.bmarques.helloworldkotlin.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bmarques.helloworldkotlin.R

class HelloWorldKotlinActivity : AppCompatActivity() {

    private val TITULO_APPBAR = "Hello World - Kotlin"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_world)
        title = TITULO_APPBAR
    }
}