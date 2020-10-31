package zadanie5

object Zadanie5 {
  def main(args: Array[String]): Unit = {
    println("Zadanie 5")
    val osoba = new Osoba("Jan", "Kowalski", 50)
    val osobaStudent = new Osoba("Adam", "Nowak", 50) with Student
    val osobaPracownik = new Osoba("Albert", "Abacki", 50) with Pracownik
    osobaPracownik.pensja = 3000
    val osobaNauczyciel = new Osoba("Henryk", "Babacki", 50) with Nauczyciel
    osobaNauczyciel.pensja = 4000
    println(s"Podatek dla osoby ${osoba.imie} ${osoba.nazwisko} wynosi: ${osoba.podatek}")
    println(s"Podatek dla studenta ${osobaStudent.imie} ${osobaStudent.nazwisko} wynosi: ${osobaStudent.podatek}")
    println(s"Podatek dla pracownika ${osobaPracownik.imie} ${osobaPracownik.nazwisko} " +
      s"o pensji ${osobaPracownik.pensja} wynosi: ${osobaPracownik.podatek}")
    println(s"Podatek dla nauczyciela ${osobaNauczyciel.imie} ${osobaNauczyciel.nazwisko} " +
      s"o pensji ${osobaNauczyciel.pensja} wynosi: ${osobaNauczyciel.podatek}")

    val osobaStudentPracownik = new Osoba("Artur", "Malina", 50) with Student with Pracownik
    osobaStudentPracownik.pensja = 3500
    val osobaPracownikStudent = new Osoba("Kamil", "Jagoda", 50) with Pracownik with Student
    osobaPracownikStudent.pensja = 3500
    println(s"Podatek dla studenta-pracownika ${osobaStudentPracownik.imie} ${osobaStudentPracownik.nazwisko} " +
      s"o pensji ${osobaStudentPracownik.pensja} wynosi: ${osobaStudentPracownik.podatek}")
    println(s"Podatek dla pracownika-studenta ${osobaPracownikStudent.imie} ${osobaPracownikStudent.nazwisko} " +
      s"o pensji ${osobaPracownikStudent.pensja} wynosi: ${osobaPracownikStudent.podatek}")
  }
}
