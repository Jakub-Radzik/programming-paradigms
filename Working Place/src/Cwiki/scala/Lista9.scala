//Jakub Radzik
package Cwiki.scala

//1
class Time(private var h: Int = 0) {
  require(h <= 23)
  if h < 0 then h = 0

  def hour: Int = h

  def hour_=(newHour: Int): Unit = {
    require(newHour < 24)
    if newHour < 0 then h = 0
    else h = newHour
  }

}

//2
class Time2A(private var h: Int, private var m: Int) {
  if h < 0 || h > 23 then throw new IllegalArgumentException("Zła godzina")
  if m < 0 || m > 59 then throw new IllegalArgumentException("Zła minuta")

  def before(other: Time2A): Boolean = {
    h < other.h || h == other.h && m < other.m
  }

  def hour: Int = h

  def minute: Int = m

  def hour_=(newHour: Int): Unit = {
    if newHour < 0 || newHour > 23 then throw new IllegalArgumentException("Zła godzina")
    else h = newHour
  }

  def minute_=(newMinute: Int): Unit = {
    if newMinute < 0 || newMinute > 59 then throw new IllegalArgumentException("Zła minuta")
    else m = newMinute
  }
}

class Time2B(h: Int, m: Int) {
  if h < 0 || h > 23 then throw new IllegalArgumentException("Zła godzina")
  if m < 0 || m > 59 then throw new IllegalArgumentException("Zła minuta")
  private var minutesAfterMidnight: Int = h * 60 + m

  def hour: Int = minutesAfterMidnight / 60

  def minute: Int = minutesAfterMidnight % 60

  def hour_=(newHour: Int): Unit = {
    if h < 0 || h > 23 then throw new IllegalArgumentException("Zła godzina")
    else minutesAfterMidnight = minute + newHour * 60
  }

  def minute_=(newMinute: Int): Unit = {
    if m < 0 || m > 59 then throw new IllegalArgumentException("Zła minuta")
    else minutesAfterMidnight = hour * 60 + newMinute
  }

  def before(other: Time2B): Boolean = {
    minutesAfterMidnight < other.minutesAfterMidnight
  }
}

//3
class Pojazd(val producent: String, val model: String, val rok: Int = -1, var rejestracja: String = "") {
  def this(producent: String, model: String, rejestracja: String) = {
    this(producent, model, -1, rejestracja)
  }

  def printInfo(): Unit = {
    println("Producent: " + producent + " Model: " + model + " Rok: " + rok + " Rejestracja: " + rejestracja)
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val g = Time
    val z = g(20)
    println(z.hour == 20)
    z.hour = 4
    println(z.hour == 4)

    val t = new Time2B(21, 37)
    val b = new Time2B(20, 17)
    print(b.before(t) == true)

    new Pojazd("Fiat", "126p", 2016, "DW1234").printInfo()
    new Pojazd("BMW", "X3", 2016).printInfo()
    new Pojazd("Volvo", "XC60", "ZKO1203").printInfo()
    new Pojazd("Opel", "Astra").printInfo()

  }
}