package day2tests

import day2.StringsPartTwo
import org.scalatest.FunSuite

class StringsPartTwoTest extends FunSuite{

  test("StringsPartTwoTest"){
    assert(StringsPartTwo.stringConnect("Ha","llo",'a','e') === "Hello")
  }

}
