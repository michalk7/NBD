package zadanie5

class Osoba (private var _imie: String, private var _nazwisko: String, private var _podatek: BigDecimal) {
  def imie: String = _imie
  def nazwisko: String = _nazwisko
  def podatek: BigDecimal = _podatek
}
