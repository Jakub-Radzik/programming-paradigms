//Jakub Radzik
package Cwiki.scala

import scala.concurrent._
import concurrent.ExecutionContext.Implicits.global

// zad 2 a
object Zad2a:
  def pairFut[A, B](fut1: Future[A], fut2: Future[B]): Future[(A, B)] =
    fut1 zip fut2

  def main(args: Array[String]): Unit =
    val pair1 = pairFut(Future { 2 + 2 }, Future { "a" })
    val pair2 = pairFut(Future { 3 }, Future { "zzzzz" })
    val pair3 = pairFut(Future { 0 }, Future { "a" })
    val pair4 = pairFut(Future { 4.4 }, Future { "a" })

    pair1.foreach(println)
    pair2.foreach(println)
    pair3.foreach(println)
    pair4.foreach(println)

end Zad2a

// zad 2 b
object Zad2b:
  def pairFut[A, B](fut1: Future[A], fut2: Future[B]): Future[(A, B)] =
    for {
      a <- fut1
      b <- fut2
    } yield (a, b)

  def main(args: Array[String]): Unit =
    val pair1 = pairFut(Future { 2 + 2 }, Future { "b" })
    val pair2 = pairFut(Future { 3 }, Future { "zzzzz" })
    val pair3 = pairFut(Future { 0 }, Future { "b" })
    val pair4 = pairFut(Future { 4.4 }, Future { "b" })

    pair1.foreach(println)
    pair2.foreach(println)
    pair3.foreach(println)
    pair4.foreach(println)

end Zad2b