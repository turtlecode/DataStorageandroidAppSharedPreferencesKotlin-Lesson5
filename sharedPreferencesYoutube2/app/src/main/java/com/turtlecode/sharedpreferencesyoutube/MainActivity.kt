package com.turtlecode.sharedpreferencesyoutube

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences : SharedPreferences
    var first_username : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this,"Welcome to app!", Toast.LENGTH_LONG).show()

        sharedPreferences = this.getSharedPreferences(
            "com.turtlecode.sharedpreferencesyoutube",
            Context.MODE_PRIVATE)
        first_username = sharedPreferences.getString("user_name","")
        if (first_username != null) {
            textView.text = "Username : ${first_username}"
        }
    }
    fun save_button (view : View) {
        val username = username_text.text.toString()
        if (username == "") {
            Toast.makeText(this,"Enter your username", Toast.LENGTH_LONG).show()
        } else {
            sharedPreferences.edit().putString(
                "user_name",username).apply()
            textView.text = "Username :" + username
        }

    }
    fun delete_button (view : View) {
        first_username = sharedPreferences.getString("user_name","")
        if (first_username != null) {
            textView.text = "Username :"
            sharedPreferences.edit().remove("user_name").apply()
        }

    }
}