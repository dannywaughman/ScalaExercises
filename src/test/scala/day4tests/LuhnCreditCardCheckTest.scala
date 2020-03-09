package day4tests

import day4.LuhnCreditCardCheck
import org.scalatest.FunSuite

class LuhnCreditCardCheckTest extends FunSuite{

  test("LuhnCreditCardCheckTest 1"){
    assert(LuhnCreditCardCheck.Luhn(49927398716L) === true)
  }

  test("LuhnCreditCardCheckTest 2"){
    assert(LuhnCreditCardCheck.Luhn(48936798214L) === false)
  }

  test("LuhnCreditCardCheckTest 3"){
    assert(LuhnCreditCardCheck.Luhn(2323200577663554L) === true)
  }

}
