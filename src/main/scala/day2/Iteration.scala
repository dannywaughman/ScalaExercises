package day2
// Create a method that accepts two parameters, a string and an integer. You method should
// print out the string provided as many times as the integer designates
object Iteration extends App  {

  def repeatString(str:String,num:Int):Unit = {


    for (i <- 1 to num ){
      println(str)
    }

  }

  repeatString("Danny",5)

}
