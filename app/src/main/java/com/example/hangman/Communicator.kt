package com.example.hangman

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Communicator : ViewModel(){
    // variable to contain message whenever
    // it gets changed/modified(mutable)
    val message = MutableLiveData<Char>()
    val currentIncompleteWord = MutableLiveData<String>()
    val guessLeft = MutableLiveData<Int>()
    val result = MutableLiveData<Int>()
    val left = MutableLiveData<Int>()
    // function to send message
    fun sendMessage(text: Char) {
        message.value = text
    // message=text
    }
    fun sendGuessLeft(g: Int)
    {
        guessLeft.value = g
    }
    fun sendIncompleteWord(iCompleteWord:String)
    {
        currentIncompleteWord.value = iCompleteWord
    }
    fun sendResult(r:Int)
    {
        result.value = r
    }
    fun sendLeft(l: Int)
    {
        left.value = l
    }
}
