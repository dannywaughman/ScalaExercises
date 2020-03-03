package day1

object AddMult extends App {

  def addMult(A:Int,B:Int,C:Int):Int = {

    val list = List(A,B,C).sorted

    val a = list(0)
    val b = list(1)
    val c = list(2)

    c * ( a + b )

  }

  println(addMult(2,7,4))
  println(addMult(1,7,7))
}
