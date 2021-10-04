val list: List[Any] = List(
  "a string",
  732,  // an integer
  'c',  // a character
  true, // a boolean value
  () => "an anonymous function returning a string"
)

list.foreach(element => println(element))

val x: Long = 78912321
val y: Float = x.toFloat
val face: Char = 'c'
val number: Int = face