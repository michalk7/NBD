import scala.annotation.tailrec

object Cw1 {
    def main(args: Array[String]): Unit = {
        //wersja Scali 2.13.3
        //zad 1
        println("Zadanie 1")
        val dniTygodnia = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")
        println("Zwykły for:")
        println(getWeekDaysStringFor(dniTygodnia))

        println("For z warunkiem:")
        println(getWeekDaysStringForOnlyPdays(dniTygodnia))

        println("While:")
        println(getWeekDaysStringWhile(dniTygodnia))

        //zad 2
        println()
        println("Zadanie 2")
        println(getWeekDaysStringRec(dniTygodnia))
        println(getWeekDaysStringRecReversed(dniTygodnia))

        //zad 3
        println()
        println("Zadanie 3")
        println(getWeekDaysStringTailRec(dniTygodnia))

        //zad 4
        println()
        println("Zadanie 4")
        println(getWeekDaysStringFoldl(dniTygodnia))
        println(getWeekDaysStringFoldr(dniTygodnia))
        println(getWeekDaysStringFoldlFiltred(dniTygodnia))

        //zad 5
        println()
        println("Zadanie 5")
        val products = Map("Gruszka" -> 2.5, "Jabłko" -> 4.0, "Fasola" -> 3.3, "Truskawka" -> 5.8, "Malina" -> 4.6)
        val updatedProducts = products.mapValues(price => price * 1.1)
        println("Produkty przed:")
        println(products.map(pair => pair._1 + "->" + pair._2).mkString(", "))
        println("Produkty po:")
        println(updatedProducts.map(pair => pair._1 + "->" + pair._2).mkString(", "))

        //zad 6
        println()
        println("Zadanie 6")
        val t3 = Tuple3("abc", 23, 5.8)
        printTuple3(t3)

        //zad 7
        println()
        println("Zadanie 7")
        val voivodeshipCapitals = Map("mazowieckie" -> "Warszawa", "świętokrzyskie" -> "Kielce", "pomorskie" -> "Gdańsk", "małopolskie" -> "Kraków")
        println("Stolica mazowsza: " + voivodeshipCapitals.get("mazowieckie"))
        println("Stolica lubelskiego: " + voivodeshipCapitals.get("lubelskie"))
        println("Stolica wielkopolski: " + voivodeshipCapitals.getOrElse("wielkopolskie", "Poznań"))

        //zad 8
        println()
        println("Zadanie 8")
        val numbers = List(0, 1, 3, 6, 0, 4, 0, 5, 7, 0, 0)
        println("Przed: " + numbers)
        val numbersWithoutZeros = filterZeros(numbers)
        println("Po: " + numbersWithoutZeros)

        //zad 9
        println()
        println("Zadanie 9")
        val numbersToMap = List(0, 1, 3, 6, 4, 5, 7, 0)
        println("Przed: " + numbersToMap)
        val numberPlusOne = addOneToAll(numbersToMap)
        println("Po: " + numberPlusOne)

        //zad 10
        println()
        println("Zadanie 10")
        val doubleNumbers = List(-12.7, 6.5, 3.2, -5.0, 12.0, 11.8, 8.8, 0, -1.9, -2, -4.2)
        println("Przed: " + doubleNumbers)
        val filtredDoubleNumbers = filterDoubleNumbers(doubleNumbers)
        println("Po: " + filtredDoubleNumbers)
    }

    //zad 1 a
    def getWeekDaysStringFor(weekDays: List[String]): String = {
        var resultString = ""
        for (day <- weekDays) {
            resultString += day + ", "
        }
        resultString.dropRight(2)
    }

    //zad 1 b
    def getWeekDaysStringForOnlyPdays(weekDays: List[String]): String = {
        var resultString = ""
        for (day <- weekDays if day.startsWith("P")) {
            resultString += day + ", "
        }
        resultString.dropRight(2)
    }

    //zad 1 c
    def getWeekDaysStringWhile(weekDays: List[String]): String = {
        var i : Int = 0
        var resultString = ""
        while(i < weekDays.length) {
            resultString += weekDays(i) + ", "
            i += 1
        }
        resultString.dropRight(2)
    }

    //zad 2 a
    def getWeekDaysStringRec(weekDays: List[String]): String = {
        if(weekDays == Nil) return ""
        if(!weekDays.tail.isEmpty) {
            weekDays.head + ", " + getWeekDaysStringRec(weekDays.tail)
        } else {
            weekDays.head
        }
    }

    //zad 2 b
    def getWeekDaysStringRecReversed(weekDays: List[String]): String = {
        if(weekDays == Nil) return ""
        if(!weekDays.tail.isEmpty) {
            weekDays.last + ", " + getWeekDaysStringRecReversed(weekDays.dropRight(1))
        } else {
            weekDays.last
        }
    }

    //zad 3
    def getWeekDaysStringTailRec(weekDays: List[String]): String = {
        @tailrec
        def weekDaysIter(weekDaysList: List[String], result: String): String = {
            if(weekDaysList == Nil) ""
            else if(weekDaysList.tail.isEmpty) result + weekDaysList.head
            else weekDaysIter(weekDaysList.tail, result + weekDaysList.head + ", ")
        }
        weekDaysIter(weekDays, "")
    }

    //zad 4 a
    def getWeekDaysStringFoldl(weekDays: List[String]): String = {
        weekDays.foldLeft("") {(acc, i) => acc + i + ", "}.dropRight(2)
    }

    //zad 4 b
    def getWeekDaysStringFoldr(weekDays: List[String]): String = {
        weekDays.foldRight("") (_ + ", " + _).dropRight(2)
    }

    //zad 4 c
    def getWeekDaysStringFoldlFiltred(weekDays: List[String]): String = {
        weekDays.filter(_.startsWith("P")).foldRight("")(_ + ", " + _).dropRight(2)
    }

    //zad 6
    def printTuple3(tuple3: Tuple3[String, Int, Double]): Unit = {
        println(tuple3._1 + ", " + tuple3._2 + ", " + tuple3._3)
    }

    //zad 8
    def filterZeros(numbers: List[Int]): List[Int] = {
        @tailrec
        def filterZerosIter(numbersList: List[Int], resultList: List[Int]): List[Int] = numbersList match {
            case Nil => resultList.reverse
            case _ => {
                if(numbersList.head != 0) {
                    val newResultList = numbersList.head :: resultList
                    filterZerosIter(numbersList.tail, newResultList)
                } else {
                    filterZerosIter(numbersList.tail, resultList)
                }
                
            }
        }
        filterZerosIter(numbers, List[Int]())
    }

    //zad 9
    def addOneToAll(numbers: List[Int]): List[Int] = {
        numbers.map(item => item + 1)
    }

    //zad 10
    def filterDoubleNumbers(numbers: List[Double]): List[Double] = {
        numbers.filter(item => item >= -5.0 && item <= 12.0).map(item => item.abs)
    }
}