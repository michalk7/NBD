package zadania_2_3_4

case class Yes[A](private val value: A) extends Maybe[A] {

  override def applyFunction[R](f: A => R): Maybe[R] = Yes(f.apply(value))

  override def getOrElse[R >: A](parameter: => R): R = value

}
