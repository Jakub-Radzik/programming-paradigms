//1
def flatten1[A](xss: List[List[A]]): List[A] = {
  if (xss.length == 0) Nil else xss.head ::: flatten1(xss.tail)
}
//1 Tests
flatten1(List(List(5, 6), List(1, 2, 3))) == List(5, 6, 1, 2, 3)
flatten1(List(List(1), List(2))) == List(1, 2)
flatten1(List(List(0))) == List(0)
flatten1(List()) == Nil

//2
def count[A](x: A, xs: List[A]): Int = {
  if (xs.length == 0) 0
  else (if (xs.head == x) 1 else 0) + count(x, xs.tail)
}
//2 Tests
count('a', List('a', 'l', 'a')) == 2
count('a', List()) == 0
count('c', List('c', 'c', 'c')) == 3
count('c', List('a', 'a', 'a')) == 0

//3
def replicate[A](x: A, n: Int): List[A] = {
  if (n < 0) throw new Exception(s"Ujemna ilość powtórzeń ! ! !") else if (n == 0) Nil else x :: replicate(x, n - 1)
}
//3 Tests
replicate("la", 3) == List("la", "la", "la")
replicate('a', 5) == List('a', 'a', 'a', 'a', 'a')
replicate('a', 1) == List('a')
replicate("abc", 2) == List("abc", "abc")
replicate(1, 2) == List(1, 1)
replicate(List(1), 3) == List(List(1), List(1), List(1))
replicate('s', 0) == Nil
//Throws an exception
//replicate('a', -1)

//4
def sqrList(xs: List[Int]): List[Int] = {
  if (xs.length == 0) Nil else (
    xs.head * xs.head :: sqrList(xs.tail)
    )
}
val sqrListFUNCTION = (xs: List[Int]) => sqrList(xs)

//4 Tests
sqrList(List(1, 2, 3, -4)) == List(1, 4, 9, 16)
sqrList(List(20)) == List(400)
sqrList(List(-20)) == List(400)
sqrList(List(0, 0, 0)) == List(0, 0, 0)
sqrList(List()) == Nil
sqrListFUNCTION(List(1, 2, 3, -4)) == List(1, 4, 9, 16)
sqrListFUNCTION(List(20)) == List(400)
sqrListFUNCTION(List(-20)) == List(400)
sqrListFUNCTION(List(0, 0, 0)) == List(0, 0, 0)
sqrListFUNCTION(List()) == Nil
//5
def palindrome[A](xs: List[A]): Boolean = {
  if (xs == xs.reverse) true else
    false
}
//5 Tests
palindrome(List('a', 'l', 'a')) == true
palindrome(List('k', 'a', 'y', 'a', 'k')) == true
palindrome(List('k', 'a', 'y', 'a')) == false
palindrome(List(1, 2, 3)) == false
palindrome(List(3, 2, 3)) == true
palindrome(List()) == true

//6
def listLength[A](xs: List[A]): Int = {
  if (xs == Nil) 0
  else 1 + listLength(xs.tail)
}
//6 Tests
listLength(List()) == 0
listLength(List(1)) == 1
listLength(List(1, 2)) == 2
listLength(List(List(1, 2), List(1, 2), List(1, 2))) == 3