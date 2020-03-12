package PeerProgrammingTests

import PeerProgramming.Taxes
import org.scalatest.FunSuite

class TaxesTest extends FunSuite {

  test ("Zero") {
    assert(Taxes.calculateTax(0) === 0)
  }
  test ("10k") {
    assert(Taxes.calculateTax(10000) === 0)
  }
  test ("30k") {
    assert(Taxes.calculateTax(30000) === 3000)
  }
  test ("100k") {
    assert(Taxes.calculateTax(100000) === 25000)
  }
  test ("1million") {
    assert(Taxes.calculateTax(1000000) === 400000)
  }
}
