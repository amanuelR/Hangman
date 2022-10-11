package com.example.hangman

import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.hangman.databinding.ActivityMainBinding

class GameResultFragment: Fragment() {
    private var gameResultTV: TextView? = null
    private val ourFontsize = 50f
    override fun onCreateView( inflater: LayoutInflater,
                               container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(getActivity(), "Click!", Toast.LENGTH_SHORT).show(); setUpFragmentGui(container)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    fun setUpFragmentGui(container: ViewGroup?) {
        if (gameResultTV == null) {
            gameResultTV = TextView(getActivity())
            gameResultTV!!.gravity = Gravity.CENTER
            gameResultTV!!.setTextSize(TypedValue.COMPLEX_UNIT_SP,
                ourFontsize)
            container!!.addView(gameResultTV)
        }
    }

    override fun onStart() {
        super.onStart()
        gameResultTV!!.text = "GOOD LUCK"
    }

    fun setResult(result: String?) {
        gameResultTV!!.text = result
    }
}
