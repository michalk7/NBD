package zadanie5

trait Pracownik extends Osoba {
  protected var _pensja: BigDecimal = 0

  def pensja = _pensja

  def pensja_=(value: BigDecimal): Unit = _pensja = value

  override def podatek: BigDecimal = _pensja * 0.2
}
