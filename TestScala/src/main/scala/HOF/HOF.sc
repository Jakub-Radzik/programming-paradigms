val sal = Seq(2, 2, 3, 4, 5, 56, 234, 234, 234, 23, 423, 423, 4234, 234)
val doubleThem = (x: Int) => x * 2
val nSal = sal.map(doubleThem)
val nSal2 = sal.map(x => x * 2)
val nSal3 = sal.map(_ * 2)

case class Forecast(temps: Seq[Double]) {
  private def convertCtoF(temp: Double) = temp * 1.8 + 32

  def InFahr: Seq[Double] = temps.map(convertCtoF)

  def InFahrMy: Seq[Double] = temps.map(_ * 1.8 + 32)
}

val c1 = new Forecast(
  Seq(2.5
    , 3.5
    , 22.4)
)
c1.InFahr
c1.InFahrMy