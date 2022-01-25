package Lab12

import java.util.concurrent.atomic.AtomicInteger

class MySemaphore(val n: Int):
  private val permits = new AtomicInteger(n)

  def getPermits: Int = permits.get()

  def acquire(num: Int): Unit =
    while (permits.get() <= 0){}
    permits.getAndAdd(-num)

  def release(num: Int): Unit =
    permits.getAndAdd(num)





