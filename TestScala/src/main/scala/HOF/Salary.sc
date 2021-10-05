object SalaryRaiser {

  private def promotion(salaries: List[Double], promFunc: Double => Double): List[Double] =
    salaries.map(promFunc)

  def smallPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, _ * 1.1)

  def bigPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, s => s * math.log(s))

  def hugePromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, math.pow(_, 2))

}

SalaryRaiser.smallPromotion(List(2, 3))
println(0.1 + 0.2)