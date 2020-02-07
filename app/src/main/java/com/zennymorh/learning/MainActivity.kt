package com.zennymorh.learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.zennymorh.learning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.submit.setOnClickListener {
            Toast.makeText(this,
                "Your username is ${binding.userName.text} " +
                    "and your password is ${binding.password.text}",
                Toast.LENGTH_SHORT).show()
        }
        //TODO: Use shared preferences to create a dashboard
        //TODO: Add a posible sign up page.
        //TODO: Use material text field
    }
}
