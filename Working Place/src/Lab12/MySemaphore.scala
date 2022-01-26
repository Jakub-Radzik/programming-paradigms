package Lab12

import java.util.concurrent.atomic.AtomicInteger

class MySemaphore(val n: Int):
  private val permits = new AtomicInteger(n)

  def getPermits: Int = permits.get()

  def acquire(num: Int = 1): Unit =
    while (permits.get() < num){}
    permits.getAndAdd(-num)

  def release(num: Int = 1): Unit =
    permits.getAndAdd(num)





