package Class

class Point(val a: Int, val b: Int){
  private var _x = a
  private var _y = b

  def x = _x
  def x_ = (newVal: Int) => _x = newVal

  def y = _y
  def y_ = (newVal: Int) => _y = newVal

  override def toString: String = s" ($_x, $_y) "
}