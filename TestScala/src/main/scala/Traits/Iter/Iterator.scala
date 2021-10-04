package Traits.Iter

trait Iterator[A] {
  def hasNext: Boolean
  def next(): A
}
