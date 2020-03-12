package PeerProgramming

object Taxes extends App {

  def calculateTax(Salary:Int):Int ={
    var Tax = 0
    if (Salary <= 10000) {
      Tax = 0
    }
    else if (Salary <= 30000) {
      Tax = (Salary - 10000) / 10
    }
    else if (Salary <= 100000) {
      Tax = 2000 + ((Salary - 30000) / 4)
    }
    else if (Salary > 1000000) {
      Tax = 2000 + 17500 + (((Salary - 100000) * 4) / 10)
    }
    Tax

  }

  // taxRate = Tax / Salary
  def overall(taxRate: Double): Int = {

    var Salary = 0
    var Tax = 0

    if (taxRate == 0) {
      Salary = taxRate.toInt
    }
    else if (taxRate <= 0.06) {

      for (i <- 10000 to 30000) {
        Tax = (i - 10000) / 10
        if (i * taxRate == Tax) {
          Salary = i
        }
      }
    }

    else if (taxRate <= 0.19) {

      var i = 30000
      var notFound = true

      while (notFound) {
        i += 1
        Tax = 2000 + ((i - 30000) / 4)

        if (Tax == (i * taxRate).toInt) {
          Salary = i
          notFound = false
        }
      }
    }

    else if (taxRate > 0.19) {

      var i = 100000
      var notFound = true

      while (notFound) {
        i += 1
        Tax = 2000 + 17500 + (((i - 100000) * 4) / 10)

        if (Tax.toFloat == (i * taxRate)) {
          Salary = i
          notFound = false
        }
      }
    }

    Salary
  }

}
