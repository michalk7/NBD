package zadanie_1

object Zadanie1 {

  def intToString(number: Int): String = s"Int: ${number}"

  def stringLength(str: String): Int = str.length

  def main(args: Array[String]): Unit = {
    val container1 = Container(55)
    val container2 = Container("Jan")
    println("Container1 getContent: " + container1.getContent)
    println("Container2 getContent: " + container2.getContent)

    val c1modified = container1.applyFunction(intToString)
    println(s"Wynik applyFunction dla Container1: ${c1modified.getContent}")
    val c2modified = container2.applyFunction(stringLength)
    println(s"Wynik applyFunction dla Container2: ${c2modified.getContent}")
  }

}
