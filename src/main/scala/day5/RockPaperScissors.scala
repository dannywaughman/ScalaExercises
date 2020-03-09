package day5

// Function to randomise rock, paper or scissors (AI)
// Function to allow user to pick rock paper or scissors
// Function to determine which wins

object RockPaperScissors extends App {

  val rock = "Rock"; val paper = "Paper"; val scissors = "Scissors"
  var wins = 0; var losses = 0
  var rCount = 0; var pCount = 0; var sCount = 0
  var comPick = ""


  def randomPick(): String = {
    var r = new scala.util.Random
    r.nextInt(3) match {
      case 0 => rock
      case 1 => paper
      case 2 => scissors
    }
  }

  def playerPick(): String = {
    println("Rock, paper or scissors?")
    scala.io.StdIn.readLine().toLowerCase() match {
      case "rock" => rock
      case "paper" => paper
      case "scissors" => scissors
    }
  }

  def AIChoice(): String = {
    if (rCount > 2) comPick = "Paper"
    else if (pCount > 2) comPick = "Scissors"
    else if (sCount > 2) comPick = "Rock"
    else comPick = randomPick()
    comPick
  }

  def playerVsAI(): Unit = {
    val pick = playerPick()
    AIChoice()

    println(s"You picked $pick ");
    println
    println(s"Computer picked $comPick");
    println

    if (pick == rock) {
      comPick match {
        case "Rock" => println("Its a draw!")
        case "Paper" => println("Computers paper covers your rock, you lose!"); losses += 1
        case "Scissors" => println("Your rock blunts computer's scissors, you win!"); wins += 1
      }
      rCount += 1; pCount = 0; sCount = 0;
    }
    else if (pick == paper) {
      comPick match {
        case "Rock" => println("Your paper covers Computer's rock, you win!"); wins += 1
        case "Paper" => println("Its a draw!")
        case "Scissors" => println("Computers scissors cut your paper, you lose!"); losses += 1
      }
      rCount = 0; pCount += 1; sCount = 0;
    }
    else if (pick == scissors) {
      comPick match {
        case "Rock" => println("Computer's rock blunts your scissors, you lose!"); losses += 1
        case "Paper" => println("Your scissors cut computer's paper, you win!"); wins += 1
        case "Scissors" => println("It's a draw!")
      }
      rCount = 0; pCount = 0; sCount += 1;
    }
    println
  }

  def playPlayerVsAI(): Unit = {
    var win = true

    while (win) {
      playerVsAI()
      println(s"Wins: $wins/10 Losses: $losses/10");
      println

      if (wins == 10) {
        println("You win the game!")
        win = false
      }
      else if (losses == 10) {
        println("Computer: better luck next time scrub")
        win = false
      }
    }
  }

  playPlayerVsAI()
}
