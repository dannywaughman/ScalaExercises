package day3

import scala.collection.mutable.ListBuffer
// CREATE GRIDS
// ADD SHIPS TO RANDOM LOCATIONS ON GRIDS


object BattleShips extends App {

  val Grid = Array.ofDim[String](13,13)
  Grid(0)(0) = "   "

  for (i<-1 to 12) {
    Grid(0)(i) = i.toString + "  "
    Grid(i)(0) = i.toString + "  "
    for (j <- 1 to 12) {
      Grid(j)(i) = "-  "
    }
  }

  Grid foreach {row => row foreach print; println(" ")}
  println("")


  //  val patrolOne = 2 long
//  val patrolTwo = 2 long
//  val battleOne = 3 long
//  val battleTwo = 3 long
//  val submarine = 3 long
//  val destroyer = 4 long
//  val carrier = 5 long

  def patrolPlacement():Unit = {

    println("Enter start x coordinate for 1x2 patrol boat in the 12x12 grid: ")
    val patrolOneX = scala.io.StdIn.readInt()
    println("Enter start y coordinate for 1x2 patrol boat in the 12x12 grid: ")
    val patrolOneY = scala.io.StdIn.readInt()
    println("Enter final x coordinate: ");
    val patrolOneXFin = scala.io.StdIn.readInt()
    println("Enter final y coordinate: ");
    val patrolOneYFin = scala.io.StdIn.readInt()

    val patrolOneStart = Grid(patrolOneX)(patrolOneY)
    val patrolOneFin = Grid(patrolOneXFin)(patrolOneYFin)

    println("Enter start coordinates for your second 1x2 patrol boat in the 12x12 grid: ")
    val patrolTwoX = scala.io.StdIn.readInt()
    println("Enter start y coordinate for 1x2 patrol boat in the 12x12 grid: ")
    val patrolTwoY = scala.io.StdIn.readInt()
    println("Enter final x coordinate: ");
    val patrolTwoXFin = scala.io.StdIn.readInt()
    println("Enter final y coordinate: ");
    val patrolTwoYFin = scala.io.StdIn.readInt()

    val patrolTwoStart = Grid(patrolTwoX)(patrolTwoYFin)
    val patrolTwoFin = Grid(patrolTwoXFin)(patrolTwoYFin)

    println("Enter start x coordinate for your first 1x3 battleship")
    val battleOneX = scala.io.StdIn.readInt()
    println("Enter start y coordinate for your first 1x3 battleship")
    val battleOneY = scala.io.StdIn.readInt()
    println("Enter second x coordinate: ");
    val battleOneXMid = scala.io.StdIn.readInt()
    println("Enter second y coordinate: ");
    val battleOneYMid = scala.io.StdIn.readInt()
    println("Enter final x coordinate: ");
    val battleOneXFin = scala.io.StdIn.readInt()
    println("Enter final y coordinate: ");
    val battleOneYFin = scala.io.StdIn.readInt()

    val battleOneStart = Grid(battleOneX)(battleOneY)
    val battleOneMid = Grid(battleOneXMid)(battleOneYMid)
    val battleOneFin = Grid(battleOneXFin)(battleOneYFin)


    println;
    println(s"Your first patrol boat: ($patrolOneX,$patrolOneY),($patrolOneXFin,$patrolOneYFin)")
    println(s"Your second patrol boat: ($patrolTwoX,$patrolTwoY),($patrolTwoXFin,$patrolTwoYFin)")
    println(s"Your first battleship: ($battleOneX,$battleOneY),($battleOneXMid,$battleOneYMid),($battleOneXFin,$battleOneYFin)");
    println

    // Running battleship
    var boats = true
    var patrolOneHits = 0
    var patrolTwoHits = 0
    var battleOneHits = 0
    var sinkCount = 0
    //      var hitCords = ListBuffer[String]()

    println("When you are ready to start the game, press any key: ")
    scala.io.StdIn.readLine()

    Grid foreach { row => row foreach print; println(" ") };
    println()
    println("Hits are marked with a 'X'. Misses are marked with a 'Ø'.");
    println()

    while (boats) {

      println("Enter target x coordinate: ")
      val xCord = scala.io.StdIn.readInt()
      println("Enter target y coordinate: ")
      val yCord = scala.io.StdIn.readInt();
      println


      if (0 > xCord || xCord > 12 || 0 > yCord || yCord > 12) {
        println("Please only enter coordinates within the 12x12 grid.");
        println
      }

      else if (xCord == patrolOneX && yCord == patrolOneY || xCord == patrolOneXFin && yCord == patrolOneYFin) {
        println(s"Hit! ($xCord,$yCord) is compromised!");
        println
        Grid(xCord)(yCord) = "X  "
        //          hitCords s"($xCord,$yCord), "
        patrolOneHits += 1
      }

      else if (xCord == patrolTwoX && yCord == patrolTwoY || xCord == patrolTwoXFin && yCord == patrolTwoYFin) {
        println(s"Hit! ($xCord,$yCord) is compromised!");
        println
        Grid(xCord)(yCord) = "X  "
        //          hitCords s"($xCord,$yCord), "
        patrolTwoHits += 1
      }

      else if (xCord == battleOneX && yCord == battleOneY || xCord == battleOneXMid && yCord == battleOneYMid
        || xCord == battleOneXFin && yCord == battleOneYFin) {
        println(s"Hit! ($xCord,$yCord) is compromised!");
        println
        Grid(xCord)(yCord) = "X  "
        battleOneHits += 1

      }

      else {
        println("Miss. Try again.");
        println
        Grid(xCord)(yCord) = "Ø  "
      }

      if (patrolOneHits == 2) {
        println("Patrol boat sunk!");
        println
        sinkCount += 1
        patrolOneHits = 0
      }
      if (patrolTwoHits == 2) {
        println("Second patrol boat sunk!");
        println
        sinkCount += 1
        patrolTwoHits = 0
      }
      if (battleOneHits == 3) {
        println("First battleship sunk!");
        println
        sinkCount += 1
        battleOneHits = 0
      }
      Grid foreach { row => row foreach print; println(" ") };
      println()
      println("Hits are marked with a 'X'. Misses are marked with a 'Ø'.");
      println()

      if (sinkCount == 3) {
        boats = false
      }


    }
  }
  println("All boats destroyed. Good job sinking those scrubs!")




  patrolPlacement()

}
