package com.example.day22project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        supportActionBar?.hide()
        // what we are taking from the precious screen

        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val imageid = intent.getIntExtra("imageId",R.drawable.pic5)

        val nameTv = findViewById<TextView>(R.id.tVName)
        val phoneTv = findViewById<TextView>(R.id.tVPhone)
        val image = findViewById<CircleImageView>(R.id.profile_image)

        //setting
        nameTv.text = name
        phoneTv.text = phone
        image.setImageResource(imageid)

    }
}