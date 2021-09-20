package com.example.tutorials

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tutorials.db.models.Person
import kotlinx.android.synthetic.main.fragment_first.*
import java.io.Serializable

class FirstFragment:Fragment(R.layout.fragment_first) {

    companion object{
        const val ARG_PERSON = "person"

        fun newInstance(person:Serializable): Fragment{
            var bundle=Bundle()
            bundle.putSerializable(ARG_PERSON,person)
            val fragment = FirstFragment()
            fragment.arguments=bundle
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val person = arguments?.getSerializable("person") as Person
        tvPerson.text = "Name is ${person.name}, age is ${person.age} from ${person.country}"
    }

}