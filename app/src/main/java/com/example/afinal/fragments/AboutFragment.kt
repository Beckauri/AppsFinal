package com.example.afinal.fragments

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.afinal.R

class AboutFragment : Fragment(R.layout.fragment_about) {

    private lateinit var editText: EditText
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        navController = Navigation.findNavController(view)

        editText = view.findViewById(R.id.textView)
    }
}