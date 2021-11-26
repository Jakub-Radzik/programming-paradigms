// Jakub Radzik

// 1
def whileLoop(condition: => Boolean, expression: => Unit): Unit = {
  if (condition) then {
    expression
    whileLoop(condition, expression)
  }
}

var count = 0;
whileLoop(count <= 3, {
  println(count);
  count += 1;
})

var x = 1;
whileLoop(x <= 20, {
  println(x);
  x *= 2;
})

// 2

//a
def swap(tab: Array[Int], i: Int, j: Int) = {
  val aux = tab(i);
  tab(i) = tab(j);
  tab(j) = aux
}

//b
def choose_pivot(tab: Array[Int], m: Int, n: Int) = tab((m + n) / 2)

def partition(tab: Array[Int], l: Int, r: Int) = {
  var i = l;
  var j = r;
  val pivot = choose_pivot(tab, l, r)
  while (i <= j) {
    while (tab(i) < pivot) i += 1
    while (pivot < tab(j)) j -= 1
    if (i <= j) then {
      swap(tab, i, j);
      i += 1;
      j -= 1
    }
  }
  (i, j)
}

//c
def quick(tab: Array[Int], l: Int, r: Int): Unit = {
  if (l < r) then {
    val (i, j) = partition(tab, l, r)
    if (j - 1 < r - i) then {
      quick(tab, l, j);
      quick(tab, i, r)
    }
    else {
      quick(tab, i, r);
      quick(tab, l, j)
    }
  } else ()
}

//d
def quicksort(tab: Array[Int]) = quick(tab, 0, tab.length - 1)