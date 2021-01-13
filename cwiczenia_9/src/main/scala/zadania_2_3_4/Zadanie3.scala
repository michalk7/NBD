package zadania_2_3_4

object Zadanie3 {

  def intToString(number: Int): String = s"Int: ${number}"

  def main(args: Array[String]): Unit = {
    val yes = Yes(666)
    val no = No()

    val yesApplyResult = yes.applyFunction(intToString)
    val noApplyResult = no.applyFunction(intToString)

    println(s"Rezultat applyFunction dla Yes: ${yesApplyResult}")
    println(s"Rezultat applyFunction dla No: ${noApplyResult}")

  }

}
