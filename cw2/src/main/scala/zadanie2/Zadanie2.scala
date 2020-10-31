package zadanie2

object Zadanie2 {
  def main(args: Array[String]): Unit = {
    println("Zadanie 2")
    val konto1 = new KontoBankowe(200)
    println("Początkowy stan: " + konto1.stanKonta)
    konto1.wyplata(100)
    println("Stan konta po wypłacie 100: " + konto1.stanKonta)
    konto1.wplata(300)
    println("Stan konta po wpłacie 300: " + konto1.stanKonta)

    val konto2 = new KontoBankowe()
    println("Początkowy stan: " + konto2.stanKonta)
    try {
      konto2.wyplata(100)
    } catch {
      case ex: Exception => println(ex.getMessage())
    }
    println("Stan konta po wypłacie 100: " + konto2.stanKonta)
    konto2.wplata(300)
    println("Stan konta po wpłacie 300: " + konto2.stanKonta)
  }
}
