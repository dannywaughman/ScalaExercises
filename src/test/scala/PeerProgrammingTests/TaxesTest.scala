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
  test ("10010") {
    assert(Taxes.calculateTax(10010) === 1)
  }
  test ("30k") {
    assert(Taxes.calculateTax(30000) === 2000)
  }
  test ("56789") {
    assert(Taxes.calculateTax(56789) === 8697)
  }
  test ("1234567") {
    assert(Taxes.calculateTax(1234567) === 473326)
  }


  test ("overall 0"){
    assert(Taxes.overall(0) === 0)
  }
  test ("overall 0.06"){
    assert(Taxes.overall(0.06) === 25000)
  }
  test ("overall 0.09"){
    assert(Taxes.overall(0.09) === 34372)
  }
  test ("overall 0.32"){
    assert(Taxes.overall(0.32) === 256250)
  }
//  test ("overall 0"){
//    assert(Taxes.overall(0.40) === assertTypeError)
//  }
}
