package day2
// Create a method that does not signify a return type and outputs whatever is given to it
object TypeInference extends App {

  def anyReturnType (something:Any): Unit = {
    println(something)
  }

  anyReturnType(1.0)
  anyReturnType("Hello World!")
  anyReturnType(15)
  anyReturnType(true)
}
