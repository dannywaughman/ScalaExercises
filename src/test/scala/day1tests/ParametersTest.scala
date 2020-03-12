package day1tests

import day1.Parameters
import org.scalatest.FunSuite

class ParametersTest extends FunSuite {

  test("Danny") {
    assert(Parameters.returnName("Danny") === "Danny")
  }

}
