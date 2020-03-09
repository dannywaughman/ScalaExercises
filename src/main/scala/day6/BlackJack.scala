package day6

import scala.collection.mutable.ListBuffer

// CPU 2 random cards out of 52 (list)
// Player inital 2 cards out of 52
// Player can stick or twist

object BlackJack extends App {

  val cardList = ListBuffer[Int]()

  for (i <- 1 to 9){
    cardList += (i,i,i,i)
  }
  for (i<-1 to 12){
    cardList += 10
  }
  for (i<-1 to 4){
    cardList += 11
  }

  def dealerCards():Int = {

    val r1 = new scala.util.Random
    val firstCard = cardList(r1.nextInt(52))
    cardList -= firstCard

    val r2 = new scala.util.Random
    val secondCard = cardList(r2.nextInt(51))
    cardList -= secondCard

    print(s"Dealer's cards: $firstCard and $secondCard. Total to beat: ")
    firstCard + secondCard

  }

  println(dealerCards())

}
