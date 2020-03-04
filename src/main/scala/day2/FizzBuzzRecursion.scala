package day2
// Rewrite your previous three iteration exercises but using method recursion, no loops
// involved.
object FizzBuzzRecursion extends App {

  def fizzBuzzRecursion(strOne:String,strTwo:String,num:Int):Unit ={


    if (num % 3 == 0 && num % 5 != 0){
      println(strOne)
    } else if (num % 5 == 0 && num % 3 != 0){
      println(strTwo)
    } else if (num % 3 == 0 && num % 5 == 0){
      println(strOne + strTwo)
    } else {
      println(num)
    }

    if (num > 1) {
      fizzBuzzRecursion(strOne, strTwo, num-1)
    }
  }

  fizzBuzzRecursion("Fizz","Buzz",15)

}
