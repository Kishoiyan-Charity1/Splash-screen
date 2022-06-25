package dev.kishoiyan.workoutlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.kishoiyan.workoutlog.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        setupBottomNav()

    }
    fun setupBottomNav(){
        binding.btmNav.setOnItemSelectedListener{ item->
            when (item.itemId){
                R.id.plan ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, PlanFragment()).commit()
                    true
                }
                R.id.track ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, TrackFragment()).commit()
                    true
                }
                R.id.profile ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, ProfileFragment()).commit()
                    true
                }
                else-> false
            }
        }
    }

}