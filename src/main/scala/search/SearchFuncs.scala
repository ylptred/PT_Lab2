package search

import sorting.Data

object SearchFuncs {

  /**
   * Простой поиск
   * @param arr - массив объектов типа Data
   * @param key - ключ
   */
  def simpleSearch(arr: Array[Data], key: String): Unit = {
    for (obj <- arr) {
      var searchArr: Array[Data] = Array.empty[Data]
      if (obj.serviceName == key) {
        searchArr = searchArr :+ obj
      }
    }
  }

  /**
   * Бинарный поиск
   * @param arr - массив объектов типа Data
   * @param key - ключ
   * @param start
   * @param end
   * @return
   */
  def binarySearch(arr: Array[Data], key: String, start: Int, end: Int): Array[Int] = {
    var res: Array[Int] = Array.empty[Int]
    if (start > end) {
      return Array.empty[Int]
    }
    val middle: Int = ((start + end) / 2).toInt
    if (arr(middle).serviceName == key) {
      res = res :+ middle
    } else if (arr(middle).serviceName > key) {
      res = binarySearch(arr, key, start, middle - 1)
    } else if (arr(middle).serviceName < key) {
      res = binarySearch(arr, key, middle + 1, end)
    }

    if (res.length == 0 || res.length > 1) {
      return res
    }

    var left = res(0) - 1
    var right = res(0) + 1

    while (left >= 0 && (right < arr.length)) {
      if (arr(left).serviceName == key) {
        res(0) = left
        left -= 1
      }
      if (arr(right).serviceName == key) {
        res = res :+ right
        right += 1
      } else {
        return res
      }
    }

    res
  }
}
