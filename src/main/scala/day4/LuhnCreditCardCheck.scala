package day4

object LuhnCreditCardCheck extends App {

  def Luhn(cardNo:Long):Boolean = {

    var cardArr = cardNo.toString.toCharArray
    var cardNoLength = cardArr.length
    var cardArrRev = cardArr.reverse
    var sum = 0
    var bool = true

    for (i <- 0 until cardNoLength by 2){

      sum += cardArrRev(i).asDigit

    }
    println("")
    for (i<-1 until cardNoLength by 2){

      var doubledDigit = cardArrRev(i).asDigit * 2

      if (doubledDigit / 10 == 1){

        var doubledDigitArr = doubledDigit.toString.toCharArray

        for (i<-0 to 1){
          sum += doubledDigitArr(i).asDigit
        }

      }
      else if (doubledDigit / 10 == 0){
        sum += doubledDigit
      }

    }

    if (sum % 10 == 0){
      bool = true
    } else {
      bool = false
    }
    bool

  }

  println(Luhn(49927398716L))
  println(Luhn(48936798214L))
  println(Luhn(2323200577663554L))
}
