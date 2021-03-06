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
  var dealerDrawCount = 2
  val r = new scala.util.Random

  for (i <- 1 to 9) {
    cardList += (i, i, i, i)
  }
  for (i <- 1 to 16) {
    cardList += 10
  }

  def dealerCards(): Int = {
    firstCompCard = cardList(r.nextInt(cardCount))
    cardCount -= 1
    cardList -= firstCompCard

    secondCompCard = cardList(r.nextInt(cardCount))
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
    firstPlayerCard = cardList(r.nextInt(cardCount))
    cardCount -= 1
    cardList -= firstPlayerCard

    secondPlayerCard = cardList(r.nextInt(cardCount))
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

    if (playerTotal == 21) {
      println("BLACKJACK!")
      result()
    }
    playerTotal

  }

  def hit(): Unit = {
    drawCount += 1
    var hitCard = cardList(r.nextInt(cardCount))
    cardCount -= 1
    println(s"You draw a $hitCard")

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
      result()
    }
    else choice()
  }

  def dealerHit(): Unit = {
    if (dealerTotal > playerTotal && dealerTotal <= 21) result()
    else if (dealerTotal >= 17 && dealerTotal <= 21) result()
    else if (dealerTotal > 21) dealerBust()
    else {
      dealerDrawCount += 1
      var dealerHitCard = cardList(r.nextInt(cardCount))
      println(s"Dealer draws a $dealerHitCard")
      cardCount -= 1
      dealerTotal += dealerHitCard
      println(s"Dealer's total: $dealerTotal")
      Thread.sleep(1000)
      dealerHit()
    }
  }

  def choice(): Unit = {

    if (drawCount == 5) {
      println("You have the maximum 5 cards on the table!")
      println(s"Dealer's cards: $firstCompCard and $secondCompCard. Total: $dealerTotal ")
      dealerHit()
    }
    println("Stick or twist?")
    val decision = scala.io.StdIn.readLine().toLowerCase()

    decision match {
      case "stick" =>
        if (firstCompCard == 11 || firstCompCard == 1){
          println(s"Dealer's cards: A and $secondCompCard. Total: $dealerTotal ")
        }
        if (secondCompCard == 11 || secondCompCard == 1){
          println(s"Dealer's cards: $firstCompCard and A. Total: $dealerTotal ")
        }
        else println(s"Dealer's cards: $firstCompCard and $secondCompCard. Total: $dealerTotal ")
        dealerHit()
      case "twist" => hit()
      case "hit me" => hit()
      case _ => println("Please enter a valid option")
        choice()
    }

  }

  def result(): Unit = {

    if (playerTotal > dealerTotal) {
      println("You win!")
      winCount += 1
      println(s"$winCount wins in a row!")
    }
    else if (dealerTotal > playerTotal) {
      println("Dealer wins!")
      winCount = 0
    }
    else if (playerTotal == 21 && dealerTotal == 21) {
      if (drawCount == 5) println("5 cards drawn, you win!")
      println(s"$winCount wins in a row!")
    }
    else if (dealerTotal == playerTotal) println("No winner")

    playAgain()
  }

  def bust(): Unit = {
    println("BUST! Try again? (Y or N)")
    winCount = 0
    playAgain()
  }

  def dealerBust(): Unit = {
    println("Dealer BUSTS! You win!")
    winCount += 1
    println(s"$winCount wins in a row!")
    playAgain()
  }

  def gameLoop(): Unit = {
    drawCount = 2
    dealerDrawCount = 2
    dealerCards()
    Thread.sleep(1000)
    println()
    playerCards()
    Thread.sleep(1000)
    choice()
  }

  def playAgain(): Unit = {
    println("Would you like to play again? (Y or N)")
    val again = scala.io.StdIn.readLine().toLowerCase()
    again match {
      case "y" => gameLoop()
        if (cardCount == 0) println("Out of cards.. sorry!")
      case "n" => println("ok bye" + cardList)
      case _ => println("Please enter a valid option")
        playAgain()
    }
  }

  gameLoop()

}
