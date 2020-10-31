package zadanie2

class KontoBankowe (private var _stanKonta: BigDecimal) {

  def this() {
    this(0.0)
  }

  def stanKonta = _stanKonta

  def wplata(kwota: BigDecimal): Unit = {
    if(kwota > 0) {
      _stanKonta += kwota
    }
  }

  def wyplata(kwota: BigDecimal): Unit = {
    if(kwota > 0) {
      if(_stanKonta > kwota) {
        _stanKonta -= kwota
      }
      else {
        throw new Exception("Brak wystarczających środków na koncie do zrealizowania tej operacji.")
      }
    }
  }
}
