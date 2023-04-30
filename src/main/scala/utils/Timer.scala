package utils

import java.util.concurrent.TimeUnit

object Timer {
  def time[R](typeSearch: String, block: => R): R = {
    val t0 = System.nanoTime()
    val result = block
    val t1 = System.nanoTime()
    println(s"[$typeSearch]  Elapsed time: " + (t1 - t0) + "ns    " + TimeUnit.MILLISECONDS.convert((t1- t0), TimeUnit.NANOSECONDS)
     + "ms    " + TimeUnit.SECONDS.convert(TimeUnit.MILLISECONDS.convert((t1 - t0), TimeUnit.NANOSECONDS), TimeUnit.MILLISECONDS) + "s")
    result
  }
}
