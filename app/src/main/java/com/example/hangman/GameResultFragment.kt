package com.example.hangman

import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hangman.MainActivity.Companion.game
import com.example.hangman.databinding.FragmentGameResultBinding
import com.example.hangman.databinding.FragmentGameStateBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GameResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameResultFragment : Fragment() {
    private var _binding: FragmentGameResultBinding? = null
    private var gameResultTV: TextView? = null
    private val ourFontsize = 50f
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameResultBinding.inflate(inflater, container, false)
        Toast.makeText(getActivity(), "Click!", Toast.LENGTH_SHORT).show();
        setUpFragmentGui(container)
        val model = ViewModelProvider(requireActivity()).get(Communicator::class.java)
        model.left.observe(viewLifecycleOwner, Observer {
            gameResultTV!!.text = "ONLY 1 LEFT"
        })

        //Implement the observe method for the result member of the class
        //Communicator. Update the message in the TextView inside the bottom right
        //pane to “YOU LOST!” or “YOU WON!”
        model.result.observe(viewLifecycleOwner, Observer {
            if (it == -1) {
                gameResultTV!!.text = "YOU Lost!"
            } else if (it == 1) {
                gameResultTV!!.text = "YOU WON!"
            }
        })
        return binding.root
    }

    fun setUpFragmentGui(container: ViewGroup?) {
        if (gameResultTV == null) {
            gameResultTV = TextView(getActivity())
            gameResultTV!!.gravity = Gravity.CENTER
            gameResultTV!!.setTextSize(
                TypedValue.COMPLEX_UNIT_SP,
                ourFontsize
            )
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