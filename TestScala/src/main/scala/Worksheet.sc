val x = 2;
val double = (x: Int) => 2 * x;
def twice = (x: Int) => 2 * x;
val twiceFun = twice;
def same[A] = (x: A) => x;
same(2);
same(2.0);
same("string");
same(true);