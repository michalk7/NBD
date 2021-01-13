package zadania_2_3_4

case class No() extends Maybe[Nothing] {

  override def applyFunction[R](f: Nothing => R): Maybe[R] = No()

  override def getOrElse[R >: Nothing](parameter: => R): R = parameter

}
