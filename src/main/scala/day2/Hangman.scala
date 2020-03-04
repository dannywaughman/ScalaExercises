package day2

import scala.collection.mutable.ListBuffer

object Hangman extends App {

  def hangMan(word:String):Unit = {

    var length = word.length()
    println(s"Your word to guess is $length letters long!")

    var game = false;

    var guessed = new StringBuilder(length* 2,"_ " * length)

    var wordArr = word.toCharArray

    var badGuessCount = 0
    var goodGuessCount = 0

    while (game == false) {

      println(guessed)

      if (goodGuessCount < word.length() || badGuessCount < 5) {

        println("Guess a letter: ")

        var input = scala.io.StdIn.readLine()
        var inputArr = input.toCharArray

        if (word.contains(input)) {
          println("Good guess!")

          for (i <- 0 to word.length() - 1 by 1) {
            if (wordArr(i) == inputArr(0)) {
              goodGuessCount += 1
              guessed.replace(i, i, input)
              if (goodGuessCount == word.length()){
                game = true
              }
            }
          }


        }


        else {
          println("Incorrect!")
          badGuessCount += 1
          if (badGuessCount == 5){
            game = true
          }
        }
      }

    }
    if (goodGuessCount == word.length()){
      println("YOU WIN!!!!!!!!!")
      println(s"The word was $word!")
    }
    else if (badGuessCount == 5) {
      println("YOU LOSE!!!!!!!")
      println(s"The word was $word!")
    }

  }

  hangMan("dannywaughman")

}
