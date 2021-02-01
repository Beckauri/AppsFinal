package com.example.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var enterButton: Button
    private lateinit var registerButton: Button


    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        if (mAuth.currentUser != null){
            gotoBMI()
        }

        setContentView(R.layout.activity_main)

        emailInput = findViewById(R.id.SignInEmail)
        passwordInput = findViewById(R.id.SignInPassword)
        enterButton = findViewById(R.id.SignInButton)
        registerButton = findViewById(R.id.registerButton)

        enterButton.setOnClickListener{

            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show()
            } else {
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {task ->
                    if (task.isSuccessful){
                        gotoBMI()
                    }

                }
            }

        }


        registerButton.setOnClickListener {

            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Empty", Toast.LENGTH_LONG).show()
                return@setOnClickListener

            }


            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {task ->
                        if (task.isSuccessful){
                            startActivity(Intent(this, MainActivity::class.java ))
                            finish()

                        } else{
                            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
                        }

                    }


        }


    }

    private fun gotoBMI() {
        startActivity(Intent(this, BMIActivity::class.java))
        finish()
    }

}