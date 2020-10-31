package zadanie3

object Zadanie3 {
  def main(args: Array[String]): Unit = {
    println("Zadanie 3")
    val osoba1 = Osoba("Jan", "Kowalski")
    val osoba2 = Osoba("Paweł", "Nowak")
    val osoba3 = Osoba("Adam", "Pingwin")
    println(sayHi(osoba1))
    println(sayHi(osoba2))
    println(sayHi(osoba3))
  }

  def sayHi(person: Osoba) = person match {
    case Osoba("Jan", "Kowalski") => "Oh, it's Jan. Where is my beer Jan?"
    case Osoba("Paweł", "Nowak") => "Hi Paweł, how is your leg?"
    case Osoba(name, surname) => s"Hi, $name $surname!"
  }
}
