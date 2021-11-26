// rozwiązanie korzysta z łączenia list
// nie działa dla list nieskończonych

def sublistL[A](list: LazyList[A]): LazyList[List[A]] = {
  def sublistIter[A](listWithPrevElems: List[A], rest: LazyList[A], result: LazyList[List[A]]): LazyList[List[A]] = {
    rest match {
      case LazyList() => {
        result
      }
      case h #:: LazyList() => {
        val a = listWithPrevElems ::: List(h);
        result #::: LazyList(a);
      }
      case h #:: t => {
        val a = listWithPrevElems ::: List(h);
        sublistIter(a, t, result #::: LazyList(a))
      }
    }
  sublistIter(List(), list, LazyList());
}

sublistL(LazyList(1,2,3,4,5,6,7,8,9,10)).take(5).toList == List(List(1), List(1, 2), List(1, 2, 3), List(1, 2, 3, 4), List(1, 2, 3, 4, 5))
sublistL(LazyList()).take(5).toList == List()
sublistL(LazyList('a', 'b', 'c', 'd','e')).take(3).toList == List(List('a'), List('a', 'b'), List('a', 'b', 'c'))
