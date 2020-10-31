package zadanie4

object Zadanie4 {
  def main(args: Array[String]): Unit = {
    val num = 3
    println(s"Wartość początkowa $num")
    val result = doThreeTimes(num, (n) => n*n)
    println(s"Wartość po wykonaniu funkcji: $result")
  }

  def doThreeTimes(num: Int, func: Int => Int): Int = {
    var result = num
    for (i <- 1 to 3) {
      result = func(result)
    }
    result
  }
}
