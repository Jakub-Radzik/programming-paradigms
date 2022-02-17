package Lab9

class Rectangle(val a: Int, val b: Int) {
  def this(a: Int) = {
    this(a, a)
  }

  def area: Int = {
    a * b
  }
}

class Handyman(val fName: String, val lName: String, val age: Int) {
  if fName.isEmpty || lName.isEmpty then throw new IllegalArgumentException("First name and last name cannot be empty")
  if age < 18 then throw new Exception("Too young")
}

trait Painter:
  Painter.existsCounter += 1

  def paint(): Unit = {
    println("Paint")
  }

trait Builder:
  Builder.existsCounter += 1

  def build(): Unit = {
    println("I will build a GREAT WALL !!!!!!")
  }

trait Electrician:
  Electrician.existsCounter += 1

  def fixElectricity(): Unit = {
    println("I will fix electricity")
  }

trait Politician:
  Politician.existsCounter += 1

  def tellLies(): Unit = {
    println("I will make Poland great again !!!")
  }

object Painter:
  private var existsCounter = 0

  def getNumberOfExists: Int = {
    existsCounter
  }

object Builder:
  private var existsCounter = 0

  def getNumberOfExists: Int = {
    existsCounter
  }

object Electrician:
  private var existsCounter = 0

  def getNumberOfExists: Int = {
    existsCounter
  }

object Politician:
  private var existsCounter = 0

  def getNumberOfExists: Int = {
    existsCounter
  }


object Test extends App {
  val r1 = new Rectangle(3, 4)
  val r2 = new Rectangle(3)
  println(r1.area)
  println(r2.area)
  println(r1.a)

  //  r1.a = 20


  //  val h1 = new Handyman("Jan", "Kowalski", 17)
  //  val h2 = new Handyman("", "Kowalski", 19)
  //  val h3 = new Handyman("Jan", "", 19)

  val h4 = new Handyman("Jan", "Kowalski", 18) with Painter
  val h5 = new Handyman("Jan", "Kowalski", 19) with Electrician with Politician
  val h6 = new Handyman("Jan", "Kowalski", 19) with Politician with Builder
  val h7 = new Handyman("Jan", "Kowalski", 19) with Builder with Electrician
  val h8 = new Handyman("Jan", "Kowalski", 19) with Painter with Electrician

  h4.paint()
  h5.fixElectricity()
  h6.tellLies()
  h6.build()

  println("Malarze: " + Painter.getNumberOfExists)
  println("Budowlance: " + Builder.getNumberOfExists)
  println("Elektrycy: " + Electrician.getNumberOfExists)
  println("Politycy: " + Politician.getNumberOfExists)

}