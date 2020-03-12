package day6

import scala.collection.mutable.ListBuffer

// CPU 2 random cards out of 52 (list)
// Player inital 2 cards out of 52
// Player can twist 3 times
// 5 cards = 21 beats dealers 21

object BlackJack extends App {

  var cardList = ListBuffer[Int]() // the deck of cards
  var playerTotal = 0
  var firstPlayerCard = 0
  var secondPlayerCard = 0
  var dealerTotal = 0
  var firstCompCard = 0
  var secondCompCard = 0
  var cardCount = 51
  var game = true
  var winCount = 0
  var drawCount = 2

  for (i <- 1 to 9) {
    cardList += (i, i, i, i)
  }
  for (i <- 1 to 16) {
    cardList += 10
  }

  def dealerCards(): Int = {
    val r1 = new scala.util.Random
    firstCompCard = cardList(r1.nextInt(cardCount))
    cardCount -= 1
    cardList -= firstCompCard

    val r2 = new scala.util.Random
    secondCompCard = cardList(r2.nextInt(cardCount))
    cardCount -= 1
    cardList -= secondCompCard

    dealerTotal = firstCompCard + secondCompCard

    print(s"Dealer's cards: $firstCompCard and ?. ")

    if (firstCompCard == 1) {
      if (dealerTotal < 11) {
        firstCompCard = 11
      }
    }
    if (secondCompCard == 1) {
      if (dealerTotal < 11) {
        secondCompCard = 11
      }
    }
    print("Total to beat: ?")
    dealerTotal
  }

  def playerCards(): Int = {
    val r1 = new scala.util.Random
    firstPlayerCard = cardList(r1.nextInt(cardCount))
    cardCount -= 1
    cardList -= firstPlayerCard

    val r2 = new scala.util.Random
    secondPlayerCard = cardList(r2.nextInt(cardCount))
    cardCount -= 1
    cardList -= secondPlayerCard

    if (firstPlayerCard == 1 && secondPlayerCard != 1) {
      if (firstPlayerCard + secondPlayerCard < 11) {
        firstPlayerCard = 11
        print(s"Your cards: A and $secondPlayerCard. ")
      }
    }
    if (secondPlayerCard == 1 && firstPlayerCard != 1) {
      if (firstPlayerCard + secondPlayerCard < 11) {
        secondPlayerCard = 11
        print(s"Your cards: $firstPlayerCard and A. ")
      }
    }
    if (secondPlayerCard != 1 && firstPlayerCard != 1) print(s"Your cards: $firstPlayerCard and $secondPlayerCard. ")
    if (secondPlayerCard == 1 && firstPlayerCard == 1) {
      firstPlayerCard = 11
      print(s"Your cards: A and $secondPlayerCard. ")
    }


    playerTotal = firstPlayerCard + secondPlayerCard
    println("Your total: " + playerTotal)
    playerTotal

  }

  def hit(): Unit = {
    drawCount += 1
    val r3 = new scala.util.Random
    var hitCard = cardList(r3.nextInt(cardCount))
    cardCount -= 1
    println(s"$hitCard drawn")

    playerTotal += hitCard

    if (firstPlayerCard == 11 && playerTotal > 21) {
      firstPlayerCard = 1
      playerTotal -= 10
    }
    else if (secondPlayerCard == 11 && playerTotal > 21) {
      secondPlayerCard = 1
      playerTotal -= 10
    }
    println(playerTotal)

    if (playerTotal > 21) bust()
    else if (playerTotal == 21) {
      println("BLACKJACK!")
      result()
    }
    else choice()
  }

  def choice(): Unit = {

    if (drawCount == 5) {
      println("You have the maximum 5 cards on the table!")
      result()
    }
    println("Stick or twist?")
    val decision = scala.io.StdIn.readLine().toLowerCase()

    decision match {
      case "stick" => result()
      case "twist" => hit()
      case "hit me" => hit()
      case _ => println("Please enter a valid option")
        choice()
    }

  }

  def result(): Unit = {

    println(s"Dealer's cards: $firstCompCard and $secondCompCard. Total: $dealerTotal ")

    if (playerTotal > dealerTotal) {
      println("You win!")
      winCount += 1
      println(s"$winCount in a row!")
    }
    else if (dealerTotal > playerTotal) {
      println("Dealer wins!")
      winCount = 0
    }
    else if (dealerTotal == playerTotal) println("No winner")

    playAgain()
  }

  def bust(): Unit = {
    println("BUST! Try again? (Y or N)")
    playAgain()
  }

  def gameLoop(): Unit = {

    drawCount = 2
    dealerCards()
    println()
    playerCards()
    choice()

  }

  def playAgain(): Unit = {
    println("Would you like to play again? (Y or N)")
    val again = scala.io.StdIn.readLine().toLowerCase()
    again match {
      case "y" => gameLoop()
        if (cardCount == 0) println("Out of cards.. sorry!")
      case "n" => println("ok bye")
      case _ => println("Please enter a valid option")
        playAgain()
    }
  }

  gameLoop()

}
