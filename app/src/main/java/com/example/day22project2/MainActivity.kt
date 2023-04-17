package com.example.day22project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var userArrayList : ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val name = arrayOf("Aryan(You)","Allu Arjun","Ambani","Sundar Pichai","Elon Musk","Murthy","Shanthan","Tate","Sai","Jayesh")
        val lastMsg = arrayOf("done","deal ok Aryan","call back Aryan","ok","What's the next plan Aryan?","hey","ok bro","Thank u Aryan","hi","enjoy")
        val lastMsgTime = arrayOf("9.00PM","8.30PM","8.01PM","4.09PM","3.30PM","1.10PM","11.00AM","7.05AM","6.00AM","yesterday")
        val phoneNumber = arrayOf("8688376361","8788604999","8347944923", "9489390348","9309333222","8522864065","9652057128","9999999999","9550961561","8074565238")
        val imgId = intArrayOf(R.drawable.pic5,R.drawable.pic4,R.drawable.pic3,R.drawable.pic2,R.drawable.pic1,R.drawable.pic12,R.drawable.pic6,R.drawable.pic8,R.drawable.pic20,R.drawable.pic13,)

        userArrayList=ArrayList()

        for (eachIndex in name.indices){
            val user = User(name[eachIndex], lastMsg[eachIndex],lastMsgTime[eachIndex],phoneNumber[eachIndex]
            ,imgId[eachIndex])

           userArrayList.add(user)
        }

        val listView = findViewById<ListView>(R.id.listView)
        listView.isClickable = true
        listView.adapter = MyAdapter(this,userArrayList)

        listView.setOnItemClickListener{ parent, view, position , id ->
            //open a new activity
            val username = name[position]
            val userphone = phoneNumber[position]
            val imageId = imgId[position]

            val i = Intent(this,UserActivity::class.java)

            i.putExtra("name",username)
            i.putExtra("phone",userphone)
            i.putExtra("imageId",imageId)
            startActivity(i)
        }



    }
}