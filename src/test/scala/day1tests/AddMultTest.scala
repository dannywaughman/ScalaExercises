package day1tests

import day1.AddMult
import org.scalatest.FunSuite

class AddMultTest extends FunSuite{

  test("2 + 7 * 4") {
    assert(AddMult.addMult(2,7,4) === 42)
  }
  test("7 + 2 * 4") {
    assert(AddMult.addMult(7,2,4) === 42)
  }
  test("1 + 7 * 7") {
    assert(AddMult.addMult(1,7,7) === 56)
  }

}
