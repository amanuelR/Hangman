package com.example.hangman

import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hangman.MainActivity.Companion.game
import com.example.hangman.databinding.FragmentGameResultBinding

class GameResultFragment : Fragment() {
    private var gameResultTV: TextView? = null
    private val ourFontsize = 50f
    private var _binding : FragmentGameResultBinding? = null
    // with the backing property of the kotlin we extract
    // the non null value of the _binding
    private val binding get() = _binding!!

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_game_control, container, false)
        _binding = FragmentGameResultBinding.inflate(inflater, container, false)
        setUpFragmentGui(container)


        //Create the ViewModel object of class Communicator
        val model = ViewModelProvider(requireActivity()).get(Communicator::class.java)

        //Implement the observe method for the left member of the class Communicator.
        // Update the message in the TextView inside the bottom right pane to
        //"ONLY 1 LEFT!"
        model.left.observe(viewLifecycleOwner, Observer {
            gameResultTV!!.text = "ONLY 1 LEFT"
        })

        //Implement the observe method for the result member of the class
        //Communicator. Update the message in the TextView inside the bottom right
        //pane to “YOU LOST!” or “YOU WON!”
        model.result.observe(viewLifecycleOwner, Observer {
            if(game.gameOver() == 1) {
                gameResultTV!!.text = "YOU WON!"
            }
            else if(game.gameOver() == -1)  {
                gameResultTV!!.text = "YOU LOST!"
            }
        })
        return binding.root
    }

    fun setUpFragmentGui(container: ViewGroup?) {
        if (gameResultTV == null) {
            gameResultTV = TextView(getActivity())
            gameResultTV!!.gravity = Gravity.CENTER
            gameResultTV!!.setTextSize(TypedValue.COMPLEX_UNIT_SP, ourFontsize)
        }
        container!!.addView(gameResultTV)
    }
    override fun onStart() { super.onStart()
        gameResultTV!!.text = "GOOD LUCK"
    }

    fun setResult(result: String?) {
        gameResultTV!!.text = result
    }
}
