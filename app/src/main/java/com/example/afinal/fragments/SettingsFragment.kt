package com.example.afinal.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.afinal.R

class SettingsFragment : Fragment(R.layout.activity_change_password) {

    private lateinit var navController: NavController
    private lateinit var editText: EditText
    private lateinit var button:Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        editText = view.findViewById(R.id.NewPasswordEditText)
        button = view.findViewById(R.id.NewPasswordSubmit)

        button.setOnClickListener {
            var amount = editText.toString().toInt()


        }
    }
}