package com.common.myapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class KotlinActivity : AppCompatActivity(), View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

//        btn_1.setText("32")
//        btn_1.setOnClickListener(this)

        var letFun = 1
        letFun?.let {

        }

    }

    override fun onClick(v: View?) {
        println("-------")
    }

}