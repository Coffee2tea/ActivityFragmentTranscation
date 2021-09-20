package com.example.tutorials

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tutorials.db.models.Person
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

                btnToNextActivity.setOnClickListener{

                    when{
                        etName.text.isNullOrEmpty() -> etName.hint = "Name can't be empty"
                        etAge.text.isNullOrEmpty() -> etAge.hint = "Age can't be empty"
                        etCountry.text.isNullOrEmpty() -> etCountry.hint = "Country can't be empty"
                        else -> {
                            val name = etName.text.toString()
                            val age = etAge.text.toString()?.toInt()
                            val country = etCountry.text.toString()

                            val person = Person(name,age,country)

                            Intent(this,LoginActivity::class.java).also {
                                it.putExtra("EXTRA_PERSON",person)
                                startActivity(it)
                            }
                        }

                    }
        }
    }
}