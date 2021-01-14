package zadanie1

object Zadanie1 {

  def numGenerator = for {
    a <- Iterator.from(1)
    b <- 1 until a+1 if a % b == 0
  } yield (a, b)

  def main(args: Array[String]): Unit = {
    val buffered = numGenerator.buffered

    println(buffered.next())

    buffered take 17 foreach println

    println(buffered.next())
    println(buffered.next())

  }

}
