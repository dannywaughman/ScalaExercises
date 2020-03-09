package day2
// Create a method that accepts two Integers as an input, then returns the sum of those integers.
object Operators extends App {

  def add (a:Int,b:Int):Int = {
    a + b
  }
  def multiply(a:Int,b:Int):Int = {
    a * b
  }

  println(add(10,20))
  println(multiply(5,6))

}
