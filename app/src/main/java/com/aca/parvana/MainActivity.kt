package com.aca.parvana

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var anvanumneriList: ArrayList<String>
   lateinit var gumariList: ArrayList<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("")

        supportActionBar!!.hide()

    anvanumneriList= ArrayList()
        gumariList= ArrayList()


        anvanumneriList.add("Պիցցա")
        anvanumneriList.add("Հոթ-Դոգ")
        anvanumneriList.add("Խմորեղեն")

        gumariList.add("500")
        gumariList.add("150")
        gumariList.add("350")






        var adapter=Adapter(anvanumneriList,gumariList)

        var recyclerView: RecyclerView=findViewById(R.id.RV)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager=LinearLayoutManager(this)

        recyclerView.setAdapter(adapter)

        btn_kanchel.setOnClickListener{

            val builder = AlertDialog.Builder(this@MainActivity)

            builder.setTitle("Կանչե՞լ Մատուցողին")

            builder.setMessage("Իսկապե՞ս ցանկանում եք կանչել մատուցողին")

            builder.setPositiveButton("Այո"){dialog, which ->


                intent = Intent(applicationContext, Main2Activity::class.java)
                startActivity(intent)
                issueNotification()


            }


            builder.setNegativeButton("Ոչ"){dialog,which ->
            }


            builder.setNeutralButton("Չգիտեմ"){_,_ ->

            }

            val dialog: AlertDialog = builder.create()


            dialog.show()
        }
    }

    fun issueNotification() {

        // make the channel. The method has been discussed before.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
         //   makeNotificationChannel("CHANNEL_1", "Example channel", NotificationManager.IMPORTANCE_DEFAULT)
        }
        // the check ensures that the channel will only be made
        // if the device is running Android 8+

        val notification = NotificationCompat.Builder(this, "CHANNEL_1")
        // the second parameter is the channel id.
        // it should be the same as passed to the makeNotificationChannel() method

        notification
            .setSmallIcon(R.mipmap.ic_launcher) // can use any other icon
            .setContentTitle("Հայտարարություն")
            .setContentText("Մատուցողը քիչ հետո կմոտենա")
            .setNumber(3) // this shows a number in the notification dots

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.notify(1, notification.build())
        // it is better to not use 0 as notification id, so used 1.
    }





}




















