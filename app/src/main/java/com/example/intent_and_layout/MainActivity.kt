package com.example.intent_and_layout

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var btnIntent : Button
    private lateinit var txtField : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIntent = findViewById(R.id.btn)
        txtField = findViewById(R.id.txtField)

        btnIntent.setOnClickListener {
            val textToShare = txtField.text.toString()

            if (textToShare.isNotEmpty()) {
                val sendIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, textToShare)
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, "Seu texto")
                startActivity(shareIntent)
            }
        }

        btnIntent.setOnLongClickListener {
            val it_Youtube = Intent(android.content.Intent.ACTION_VIEW)
            it_Youtube.data= Uri.parse("https://www.youtube.com/")
            startActivity(it_Youtube);
            true
        }

//        btnIntent.setOnLongClickListener(View.OnLongClickListener {})

    }
}