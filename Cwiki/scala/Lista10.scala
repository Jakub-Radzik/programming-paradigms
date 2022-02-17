//Jakub Radzik

object Lista10 extends App {

  //  4
  import scala.collection.mutable

  def copy[T](dest: mutable.Seq[T], src: mutable.Seq[T]): Unit = {
    require(dest.length >= src.length)
    var i = 0
    src.foreach(elem => {
      dest.update(i, elem)
      i = i + 1
    })
  }

  val a = mutable.Seq(1, 2, 3, 4, 5)
  val b = mutable.Seq(6, 6, 6)
  copy(a, b)
  print(a)
}

