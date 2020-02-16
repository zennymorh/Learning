package com.zennymorh.learning

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.zennymorh.learning.databinding.ActivityDashboardBinding
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_main.*

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)


        val sharedPreferences: SharedPreferences =
            getSharedPreferences("com.zennymorh.learning", Context.MODE_PRIVATE)


        val savedUserName = sharedPreferences.getString("username", null)

        if (savedUserName == null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.user.text = "Username: $savedUserName"
    }
}
