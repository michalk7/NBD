package zadania_2_3_4

object Zadanie4 {

  def main(args: Array[String]): Unit = {
    val yes = Yes(666)
    val no = No()

    println(s"getOrElse dla Yes: ${yes.getOrElse(123)}")
    println(s"getOrElse dla No: ${no.getOrElse(890)}")

  }
}
