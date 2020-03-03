package day1

object BottlesOfBeer extends App {

  def bottlesOfBeer(bottles:Int):Unit = {

    var i = bottles

    while
    (i>1){
      var j = i-1
      println(s"$i bottles of beer on the wall, $i bottles of beer! You take one down, pass it around, $j bottles of beer on the wall!")
      i -= 1
    }
    println(s"$i bottles of beer on the wall, $i bottles of beer! You take one down, pass it around, time to go buy some more!")
  }

  bottlesOfBeer(100)

}
