package com.example.firebaseapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

class MainActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
    }

    @SuppressLint("ShowToast")
    fun loginClicked(view: View){

    }
    @SuppressLint("ShowToast")
    fun registerClicked(view: View){

        val email = userEmailText.text.toString()
        val pw = passwordText.text.toString()

        auth.createUserWithEmailAndPassword(email,pw).addOnCompleteListener { task ->

            if(task.isSuccessful){
                val intent = Intent(applicationContext,FeedActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener {exception ->
            if(null != exception) {
                Toast.makeText(applicationContext, exception.localizedMessage.toString(), Toast.LENGTH_LONG)
            }
        }
    }
}
