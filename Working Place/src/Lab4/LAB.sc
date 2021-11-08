sealed trait bt[+A]

case object Empty extends bt[Nothing]

case class Node[+A](elem: A, bt_1: bt[A], bt_2: bt[A], bt_3: bt[A]) extends bt[A]

val int_tree = Node(1,
  Node(2, Empty, Node(5, Empty, Empty, Empty), Empty),
  Node(3, Node(6, Empty, Empty, Empty), Empty, Empty),
  Node(4, Empty, Empty, Node(7, Empty, Empty, Empty))
);

val string_tree = Node("a",
  Node("b", Empty, Node("e", Empty, Empty, Empty), Empty),
  Node("c", Node("f", Empty, Empty, Empty), Empty, Empty),
  Node("d", Empty, Empty, Node("g", Empty, Empty, Empty))
);

def mapTree3[A](f: A=>A)(bt: bt[A]):bt[A] = {
  bt match {
    case Empty => Empty
    case Node(elem, bt_1, bt_2, bt_3) => Node(f(elem), mapTree3(f)(bt_1), mapTree3(f)(bt_2), mapTree3(f)(bt_3))
  }
}

val multiplyByTwo:Int=>Int = x => x*2;
val concat:String=>String = x => x+x;

mapTree3(multiplyByTwo)(int_tree) == Node(2,Node(4,Empty,Node(10,Empty,Empty,Empty),Empty),Node(6,Node(12,Empty,Empty,Empty),Empty,Empty),Node(8,Empty,Empty,Node(14,Empty,Empty,Empty)));
mapTree3(multiplyByTwo)(Empty) == Empty;
mapTree3(concat)(string_tree) == Node("aa",Node("bb",Empty,Node("ee",Empty,Empty,Empty),Empty),Node("cc",Node("ff",Empty,Empty,Empty),Empty,Empty),Node("dd",Empty,Empty,Node("gg",Empty,Empty,Empty)));

//2

//a
case class Word(first_letter: Char, rest_of_word: String)

trait Sentences
case class Declarative(word: Word, words: List[Word]) extends Sentences
case class Exclamatory(word: Word, words: List[Word]) extends Sentences
case class Interrogative(word: Word, words: List[Word]) extends Sentences

case class Text(sentences: List[Sentences])
