package day2
// Create a method that accepts two parameters, one being a string and one being an integer.
// You method should return the amount of characters from the end of the string that the
// integer specifies
object Strings extends App {

  def lastString(word:String,num:Int):String = {

    word.takeRight(num)

  }

  println(lastString("Hello",3))

  println(lastString("Danny",2))

}
