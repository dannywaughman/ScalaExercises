package day2tests

import day2.Operators
import org.scalatest.FunSuite

class OperatorsTest extends FunSuite {

  test("add.testOne"){
    assert(Operators.add(10,20) === 30)
  }
  test("add.testTwo"){
    assert(Operators.add(50,50) === 100)
  }
  test("multiply.testOne"){
    assert(Operators.multiply(5,6) === 30)
  }

}
