package day2
// Create a method that accepts 4 parameters, two being a String and two being a character,
// your method will then join both strings together and then replace all occurrences of the
// character provided with the second character provided.
object StringsPartTwo extends App {

  def stringConnect (strOne:String, strTwo: String, charOne:Char,charTwo:Char):String = {

    val strThree = strOne.concat(strTwo)

    strThree.replace(charOne,charTwo)

  }

  println(stringConnect("Ha","llo",'a','e'))

}
