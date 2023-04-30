package search

import sorting.Data

object SearchFuncs {
  def simpleSearch(arr: Array[Data], key: String): Unit = {
    for (obj <- arr) {
      var searchArr: Array[Data] = Array.empty[Data]
      if (obj.serviceName == key) {
        searchArr = searchArr :+ obj
      }
    }
  }

  def binarySearch(arr: Array[Data], key: String): Unit = {
    var low = 0
    var high = arr.length - 1
    var searchArr: Array[Data] = Array.empty[Data]

    while (low <= high) {
      val mid: Int = (low + high) / 2
      val midVal = arr(mid)
      if (midVal.serviceName == key) {
        searchArr = searchArr :+ midVal
      }
      if (midVal.serviceName > key) {
        high = mid - 1
      } else {
        low = mid + 1
      }
    }
  }
}
