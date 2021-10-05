
def foldLeft1[Int](as: List[Int], b0: Int = 0, op: (Int, Int) => Int) = {
  as.foreach(elem=> op(b0, elem))
}

foldLeft1(List.range(1,5), 0, _ + _)