package com.example.tutorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.tutorials.R.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_login)

        val person= intent.getSerializableExtra("EXTRA_PERSON")

        val firstFragment = person?.let { FirstFragment.newInstance(it) }
        val secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction().apply {
            if (firstFragment != null) {
                replace(id.flFragment, firstFragment)
            }
            commit()
        }

        btnFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                if (firstFragment != null) {
                    replace(id.flFragment, firstFragment)
                }
                commit()
            }
        }

        btnFragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(id.flFragment, secondFragment)
                commit()
            }
        }


    }


}