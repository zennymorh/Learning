package com.zennymorh.learning

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.zennymorh.learning.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        val sharedPreferences: SharedPreferences =
            getSharedPreferences("com.zennymorh.learning", Context.MODE_PRIVATE)

        binding.submit.setOnClickListener {
            Toast.makeText(this,
                "Login successful",
                Toast.LENGTH_SHORT).show()

            val userName = binding.userName.text.toString()
            val password = binding.password.text.toString()


            //Getting input from user and saving it in sharedPref

            val editor = sharedPreferences.edit()
            editor.putString("username", userName).apply()
            editor.putString("password", password).apply()

            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

}
