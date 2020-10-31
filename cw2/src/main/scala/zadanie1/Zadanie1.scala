package zadanie1

object Zadanie1 {
  def main(args: Array[String]): Unit = {
    //wersja Scali 2.13.3
    println("Zadanie 1")
    val data = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela", "Jan", "SobotoPiątnik", "Kerotw", "Atobos")
    data.foreach(item => println(s"Input dla funkcji: $item => Output funkcji: ${getDayInfo(item)}"))
  }

  def getDayInfo(day: String): String = {
    val workingDays = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek")
    val weekDays = List("Sobota", "Niedziela")
    day match {
      case d if workingDays contains d => "Praca"
      case d if weekDays contains d => "Weekend"
      case _ => "Nie ma takiego dnia"
    }
  }
}
