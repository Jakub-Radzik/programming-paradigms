//1

//tree
sealed trait tree3[+A]

case object Empty extends tree3[Nothing]

case class Node[+A](elem: A, bt_1: tree3[A], bt_2: tree3[A], bt_3: tree3[A]) extends tree3[A]

//int tree
val n7 = Node(7, Empty, Empty, Empty);
val n6 = Node(6, Empty, Empty, Empty);
val n5 = Node(5, Empty, Empty, Empty);
val n4 = Node(4, Empty, Empty, n7);
val n3 = Node(3, n6, Empty, Empty);
val n2 = Node(2, Empty, n5, Empty);
val int_tree = Node(1, n2, n3, n4);


def mapTree3[A,B](f: A => B)(bt: tree3[A]): tree3[B] = {
  bt match {
    case Empty => Empty
    case Node(elem, bt_1, bt_2, bt_3) => Node(f(elem), mapTree3(f)(bt_1), mapTree3(f)(bt_2), mapTree3(f)(bt_3))
  }
}

val multiplyByTwo:Int=>Int = x => x*2;

mapTree3(multiplyByTwo)(int_tree) == Node(2,Node(4,Empty,Node(10,Empty,Empty,Empty),Empty),Node(6,Node(12,Empty,Empty,Empty),Empty,Empty),Node(8,Empty,Empty,Node(14,Empty,Empty,Empty)));
mapTree3(multiplyByTwo)(Empty) == Empty;

//2

//a
case class Word(first_letter: Char, rest_of_word: String)

sealed trait Sentence
case class Declarative(first_word: Word, rest_of_words: List[Word]) extends Sentence
case class Exclamatory(first_word: Word, rest_of_words: List[Word]) extends Sentence
case class Interrogative(first_word: Word, rest_of_words: List[Word]) extends Sentence

case class Text(first_sentence: Sentence, rest_of_sentences: List[Sentence])

//test types:

val ala = Word('a', "la");
val ma = Word('m', "a");
val kota = Word('k', "ota");

val declarative = Declarative(ala, List(ma, kota))
val exclamatory = Exclamatory(ala, List(ma, kota))
val interrogative = Interrogative(ala, List(ma, kota))

val text = Text(declarative, List(exclamatory, interrogative))
