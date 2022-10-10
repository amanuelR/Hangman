package com.example.hangman

import java.util.*


class Hangman(guesses: Int) {
    private val words = arrayOf("ANDROID", "JAVA", "APP", "MOBILE")
    private val word: String
    private val indexesGuessed: BooleanArray
    var guessesAllowed = 0
    var guessesLeft: Int
        private set
    fun guess(c: Char) {
        var goodGuess = false
        for (i in 0 until word.length) {
            if (!indexesGuessed[i] && c == word[i]) {
                indexesGuessed[i] = true
                goodGuess = true
            }
        }
        if (!goodGuess) guessesLeft--
    }

    fun currentIncompleteWord(): String {
        var guess = ""
        for (i in 0 until word.length) guess += if (indexesGuessed[i]) word[i].toString() + " " else "_ "
        return guess
    }

    fun gameOver(): Int {
        var won = true
        for (i in indexesGuessed.indices)
            if (indexesGuessed[i] == false) {
                won = false
                 break
             }
        return if (won) // won
                1 else if (guessesLeft == 0) // lost
                -1 else  // game not over
                  0
    }

    companion object {
        var DEFAULT_GUESSES = 6
    }

    init {
        guessesAllowed = if (guesses > 0) guesses else DEFAULT_GUESSES
        guessesLeft = guessesAllowed
        val random = Random()
        val index = random.nextInt(words.size)
        word = words[index]
        indexesGuessed = BooleanArray(word.length)
    }
}