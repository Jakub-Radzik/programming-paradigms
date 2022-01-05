package wykład.w9

class Hour {
  private var h: Int = _

  def hour: Int = h

  def hour_=(newHour: Int): Unit = {
    require(newHour >= 0 && newHour < 24, s"newHour: $newHour")
    h = newHour
  }
}

