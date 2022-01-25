// 1:
def reverse4[A, B, C, D](list: (A, B, C, D)) = {
  (list._4, list._3, list._2, list._1)
}
reverse4((1, 2, 3, 4))
reverse4((1, 2.5, 'a', "siema"))

// 2:
def substitute[A](list: List[A], el1: A, el2: A): List[A] = {
  if list == List() then List() else
    (if list.head == el1 then el2 else list.head) :: substitute(list.tail, el1, el2)
}

substitute(List(1, 2, 3, 4, 5, 6, 7, 8), 2, 10)
substitute(List(2, 2, 2, 2), 2, 10)
substitute(List(0, 0, 0, 1, 1, 1), 2, 11)

// 3:

def insert[A](list: List[A], elem: A, idx: Int): List[A] = {
  if idx < 0 then elem :: list else if
  idx > 0 && list.length > 0 then
  list.head :: insert(list.tail, elem, idx - 1) else if
  list.length > 0 then elem :: list.head :: list.tail else
  elem :: List()
}

insert(List(1, 2, 3, 4, 5), 10, -10);
insert(List(1, 2, 3, 4, 5), 10, 1);
insert(List(1, 2, 3, 4, 5), 10, 4);
insert(List(1, 2, 3, 4, 5), 10, 10);
insert(List(1, 2, 3, 4, 5), 10, 20);

