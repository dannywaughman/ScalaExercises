package day2
// Create a method accepts two parameters, one a String and the other an integer, your
// method will then output that string in a rectangle-like fashion as many times as the number
// dictates.
object IterationTwo extends App {

  def repeatStringRec(str:String,num:Int):Unit = {

    var numStr = str * num

    for (i <- 1 to num){
      println(numStr)
    }

  }

  repeatStringRec("D",5)

}
