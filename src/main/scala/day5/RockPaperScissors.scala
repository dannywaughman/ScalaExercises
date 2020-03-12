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
    val m = scala.io.StdIn.readLine().toLowerCase()
    m match {
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

  def playerVsAI(): String = {
    val pick = playerPick()
    AIChoice()

    println(s"You picked $pick ");
    println
    println(s"Computer picked $comPick");
    println

    var response = ""

    if (pick == rock) {
      comPick match {
        case "Rock" => response = "Its a draw!"
        case "Paper" => response = "Computers paper covers your rock, you lose!"; losses += 1
        case "Scissors" => response = "Your rock blunts computer's scissors, you win!"; wins += 1
      }
      rCount += 1; pCount = 0; sCount = 0;
    }
    else if (pick == paper) {
      comPick match {
        case "Rock" => response = "Your paper covers Computer's rock, you win!"; wins += 1
        case "Paper" => response = "Its a draw!"
        case "Scissors" => response = "Computers scissors cut your paper, you lose!"; losses += 1
      }
      rCount = 0; pCount += 1; sCount = 0;
    }
    else if (pick == scissors) {
      comPick match {
        case "Rock" => response = "Computer's rock blunts your scissors, you lose!"; losses += 1
        case "Paper" => response = "Your scissors cut computer's paper, you win!"; wins += 1
        case "Scissors" => response = "It's a draw!"
      }
      rCount = 0; pCount = 0; sCount += 1;
    }
    response
  }

  def playPlayerVsAI(): String = {
    var win = true
    var result = ""

    while (win) {
      println(playerVsAI())
      println(s"Wins: $wins/10 Losses: $losses/10");
      println

      if (wins == 10) {
        result = "You win the game!"
        win = false
      }
      else if (losses == 10) {
        result = "Computer: better luck next time scrub"
        win = false
      }
    }
    result
  }

  println(playPlayerVsAI())
}
