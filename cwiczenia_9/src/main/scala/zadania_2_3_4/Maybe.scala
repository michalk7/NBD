package zadania_2_3_4

trait Maybe[+A] {

  def applyFunction[R](f: A=> R): Maybe[R]

  def getOrElse[R >: A](parameter: => R): R

}
