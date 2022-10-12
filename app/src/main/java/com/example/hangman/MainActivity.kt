package com.example.hangman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hangman.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val fragmentManager = supportFragmentManager
    companion object{
            var game = Hangman(6)
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    // setContentView(R.layout.activity_main)
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.game_state, GameStateFragment())
        fragmentTransaction.add(R.id.game_result, GameResultFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}

