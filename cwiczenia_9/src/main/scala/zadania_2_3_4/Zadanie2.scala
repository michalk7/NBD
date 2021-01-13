package zadania_2_3_4

object Zadanie2 {

  def main(args: Array[String]): Unit = {
    val yes = Yes("hello")
    val no = No()
    println(s"Czy obiekt typu ${yes.getClass().getSimpleName()} jest podtypem Maybe[_]? -> ${yes.isInstanceOf[Maybe[_]]}")
    println(s"Czy obiekt typu ${no.getClass().getSimpleName()} jest podtypem Maybe[_]? -> ${no.isInstanceOf[Maybe[_]]}")
  }
}
