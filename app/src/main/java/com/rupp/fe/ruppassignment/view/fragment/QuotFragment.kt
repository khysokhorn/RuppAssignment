package com.rupp.fe.ruppassignment.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.rupp.fe.ruppassignment.R

class QuotFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_quot, container, false)
        val et: TextInputEditText = view.findViewById(R.id.etClickMeInside)

        et.setOnClickListener {
            Toast.makeText(context, "Message show", Toast.LENGTH_LONG).show()
        }
        return view
    }


}