package day3

import scala.collection.mutable.ListBuffer
// CREATE GRIDS
// ADD SHIPS TO RANDOM LOCATIONS ON GRIDS


object BattleShips extends App {

  val Grid = Array.ofDim[Int](12,12)

//  val patrolOne = 2 long
//  val patrolTwo = 2 long
//  val battleOne = 3 long
//  val battleTwo = 3 long
//  val submarine = 3 long
//  val destroyer = 4 long
//  val carrier = 5 long

  def patrolPlacement():Unit = {


      println("Enter start x coordinate for 1x2 patrol boat in a 12x12 grid: ")
      val patrolOneX = scala.io.StdIn.readInt()
      println("Enter start y coordinate for 1x2 patrol boat 12x12 grid: ")
      val patrolOneY = scala.io.StdIn.readInt()
      println("Enter final x coordinate for 1x2 patrol boat 12x12 grid: ")
      val patrolOneXFin = scala.io.StdIn.readInt()
      println("Enter final y coordinate for 1x2 patrol boat in a 12x12 grid: ")
      val patrolOneYFin = scala.io.StdIn.readInt()

      println("Enter start x coordinate for your second 1x2 patrol boat in a 12x12 grid: ")
      val patrolTwoX = scala.io.StdIn.readInt()
      println("Enter start y coordinate for 1x2 patrol boat 12x12 grid: ")
      val patrolTwoY = scala.io.StdIn.readInt()
      println("Enter final x coordinate for 1x2 patrol boat 12x12 grid: ")
      val patrolTwoXFin = scala.io.StdIn.readInt()
      println("Enter final y coordinate for 1x2 patrol boat in a 12x12 grid: ")
      val patrolTwoYFin = scala.io.StdIn.readInt()

      println(s"Your first patrol boat: ($patrolOneX,$patrolOneY),($patrolOneXFin,$patrolOneYFin)")
      println(s"Your second patrol boat: ($patrolTwoX,$patrolTwoY),($patrolTwoXFin,$patrolTwoYFin)")


    // Running battleship
      var boats = true
      var patrolOneHits = 0
      var patrolTwoHits = 0
      var sinkCount = 0
//      var hitCords = ListBuffer[String]()

      println("When you are ready to start the game, press any key: ")
      scala.io.StdIn.readLine()

      while (boats) {
//        println("Coordinates hit: " )

        println("Enter target x coordinate: ")
        val xCord = scala.io.StdIn.readInt()
        println("Enter target y coordinate: ")
        val yCord = scala.io.StdIn.readInt()

        if (0 > xCord || xCord > 12 || 0 > yCord || yCord > 12){
          println("Please enter coordinates within the 12x12 grid.")
        }

        else if (xCord == patrolOneX && yCord == patrolOneY || xCord == patrolOneXFin && yCord == patrolOneYFin) {
          println(s"Hit! ($xCord,$yCord) is compromised!")
//          hitCords s"($xCord,$yCord), "
          patrolOneHits += 1
        }

        else if (xCord == patrolTwoX && yCord == patrolTwoY || xCord == patrolTwoXFin && yCord == patrolTwoYFin) {
          println(s"Hit! ($xCord,$yCord) is compromised!")
          //          hitCords s"($xCord,$yCord), "
          patrolTwoHits += 1
        }

        else {
          println("Miss. Try again.")
        }


        if (patrolOneHits == 2){
          println("First patrol boat sunk!")
          sinkCount += 1
        }
        if (patrolTwoHits == 2){
          println("Second patrol boat sunk!")
          sinkCount += 1
        }

        if (sinkCount == 2){
          boats = false
        }

      }

    println("All boats destroyed. Good job sinking those scrubs!")

  }


  patrolPlacement()

}
