package Lab12

object IntWrapper:
  private var i: Int = 0
  private val semaphore = new MySemaphore(1)

  def get: Int =
    try {
      semaphore.acquire()
    } catch {
      case e: InterruptedException =>
        println("InterruptedException")
    }
    i

  def set(x: Int): Unit =
    i = x
    semaphore.release()

class Count extends Thread :
  override def run(): Unit =
    for (i <- 0 to 100000)
      val temp: Int = IntWrapper.get
      IntWrapper.set(temp + 1)

object Lab12:
  def main(args: Array[String]): Unit =
    val c1: Count = new Count()
    val c2: Count = new Count()
    c1.start()
    c2.start()

    try {c1.join(); c2.join()}
    catch {
      case e: InterruptedException => println(e)
    }
    println("n =" + IntWrapper.get)
