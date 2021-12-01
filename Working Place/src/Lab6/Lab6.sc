// Jakub Radzik
// Zadanie 2

def modifiedPascalF(n: Int): List[Int] = {

  def sumOfArrays(a: List[Int], b: List[Int]): List[Int] =
    (a, b) match {
      case (Nil, _) => b
      case (_, Nil) => a
      case (x :: xs, y :: ys) => (x + y) :: sumOfArrays(xs, ys)
    }

  def differenceOfArray(a: List[Int], b: List[Int]): List[Int] =
    (a, b) match {
      case (Nil, _) => b
      case (_, Nil) => a
      case (x :: xs, y :: ys) => (x - y) :: differenceOfArray(xs, ys)
    }

  def modifiedPascalIter(n: Int): List[Int] = {
    n match {
      case 0 => List(1)
      case _ => {
        val previous = modifiedPascalIter(n - 1)
        if n % 2 == 0 then
          1 :: sumOfArrays(previous, previous.drop(1))
        else
          1 :: differenceOfArray(previous, previous.drop(1))

      }
    }
  }
  modifiedPascalIter(n)
}

def modifiedPascalI(n: Int): Array[Int] =
  var arr = new Array[Int](n + 1);
  var arrHelper = new Array[Int](n + 1);
  arr(0) = 1;
  arrHelper(0) = 1;
  var i = 1;
  while i < n + 1 do {
    if (i == 1) {
      arr(1) = 1
    }
    else if (i % 2 == 0) {
      var j = 1;
      while j < i + 1 do
        arrHelper(j) = arr(j - 1) + arr(j)
        j += 1
    end while
    }
    else {
      var k = 1;
      while k < i + 1 do
        arr(k) = arrHelper(k - 1) - arrHelper(k)
        k += 1
      end while
    }
    i += 1
  }
  if (n % 2 == 0) then arrHelper
  else arr


modifiedPascalF(0) == modifiedPascalI(0).toList
modifiedPascalF(1) == modifiedPascalI(1).toList
modifiedPascalF(2) == modifiedPascalI(2).toList
modifiedPascalF(3) == modifiedPascalI(3).toList
modifiedPascalF(4) == modifiedPascalI(4).toList
modifiedPascalF(5) == modifiedPascalI(5).toList
modifiedPascalF(6) == modifiedPascalI(6).toList
modifiedPascalF(7) == modifiedPascalI(7).toList

