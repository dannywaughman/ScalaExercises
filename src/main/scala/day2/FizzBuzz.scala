package day2
// Create a method that accepts three parameters, two strings and one integer. Your method
// will then loop from 1 to the integer provided, outputting the current iteration count every
// iteration.
// However if the current iteration is divisible by 3, output the first String provided.
// If the current iteration is divisible by 5, output the second String provided.
// If it is divisible by both 3 and 5, then output the concatenation of the two Strings.
object FizzBuzz extends App {

  def fizzBuzz(strOne:String,strTwo:String,num:Int):Unit = {

    for (i <- 1 to num){

      var strThree = ""

      if (i % 3 == 0){
        strThree = strThree.concat(strOne)
      }
      if (i % 5 == 0){
        strThree = strThree.concat(strTwo)
      }
      if (i % 3 != 0 && i % 5 != 0) {
        print(i + ",")
      }
      if (strThree != "") {
        print(strThree + ",")
      }
    }

  }
  fizzBuzz("Fizz","Buzz",15)
}
