package day1

import org.scalatest.FunSuite

class ParametersTest extends FunSuite {

  test("Danny") {
    assert(Parameters.returnName("Danny") === "Danny")
  }

}
