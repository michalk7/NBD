package zadanie_1

case class Container[A](private val value: A) {

  def getContent: A = value

  def applyFunction[R](f: A => R): Container[R] = {
    Container(f(value))
  }

}
