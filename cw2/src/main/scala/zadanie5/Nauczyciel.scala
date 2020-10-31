package zadanie5

trait Nauczyciel extends Pracownik {
  override def podatek: BigDecimal = _pensja * 0.1
}
