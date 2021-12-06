// Jakub Radzik
// Zadanie 2

def modifiedPascalF(n: Int): List[Int] = {

    // HOF - addition or difference
    def operationOfList(a: List[Int], b: List[Int], op: (Int, Int) => Int): List[Int] =
      (a, b) match {
        case (Nil, _) => b
        case (_, Nil) => a
        case (x :: xs, y :: ys) => op(x, y) :: operationOfList(xs, ys, op)
      }

  def modifiedPascalIter(n: Int): List[Int] = {
    n match {
      case 0 => List(1)
      case _ => {
        val previous = modifiedPascalIter(n - 1)
        if n % 2 == 0 then
          1 :: operationOfList(previous, previous.drop(1), _ + _)
        else
          1 :: operationOfList(previous, previous.drop(1), _ - _)
      }
    }
  }

  modifiedPascalIter(n)
}

modifiedPascalF(0)
modifiedPascalF(1)
modifiedPascalF(2)
modifiedPascalF(3)
modifiedPascalF(4)
modifiedPascalF(5)
modifiedPascalF(6)
modifiedPascalF(7)

def modifiedPascalI(n: Int): Array[Int] =
  var array_1 = new Array[Int](n + 1)
  var array_2 = new Array[Int](n + 1)

  array_1(0) = 1
  array_2(0) = 1

  var i = 1
  while i < n + 1 do {

    if i == 1 then array_1(1) = 1
    else if i % 2 == 0 then {

      var j = 1
      while j < i + 1 do
        array_2(j) = array_1(j - 1) + array_1(j)
        j += 1

    }
    else {

      var j = 1
      while j < i + 1 do
        array_1(j) = array_2(j - 1) - array_2(j)
        j += 1

    }

    i += 1
  }

  if n % 2 == 0 then array_2
  else array_1

modifiedPascalI(0)
modifiedPascalI(1)
modifiedPascalI(2)
modifiedPascalI(3)
modifiedPascalI(4)
modifiedPascalI(5)
modifiedPascalI(6)
modifiedPascalI(7)

modifiedPascalI(0).toList == modifiedPascalF(0)
modifiedPascalI(1).toList == modifiedPascalF(1)
modifiedPascalI(2).toList == modifiedPascalF(2)
modifiedPascalI(3).toList == modifiedPascalF(3)
modifiedPascalI(4).toList == modifiedPascalF(4)
modifiedPascalI(5).toList == modifiedPascalF(5)
modifiedPascalI(6).toList == modifiedPascalF(6)
modifiedPascalI(7).toList == modifiedPascalF(7)