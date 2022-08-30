package dev.kishoiyan.workoutlog.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.kishoiyan.workoutlog.R
import dev.kishoiyan.workoutlog.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var btmNav: BottomNavigationView
    lateinit var fcvHome:FragmentContainerView
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castViews()
        setupBottomNav()

    }
    fun castViews(){
        btmNav =findViewById(R.id.btmNav)
        fcvHome= findViewById(R.id.fcvHome)

    }

    fun setupBottomNav(){
        binding.btmNav.setOnItemSelectedListener{ item->
            when (item.itemId){
                R.id.plan ->{
                    val transaction=supportFragmentManager.beginTransaction()
                        .replace(R.id.fcvHome, PlanFragment())
                    transaction.commit()
                    true
                }
                R.id.track ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fcvHome, TrackFragment()).commit()
                    true
                }
                R.id.profile ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fcvHome, ProfileFragment()).commit()
                    true
                }
                else-> false
            }
        }
    }

}