package utils.sort

import sorting.Data

object Sort {

  /**
   * Метод шейкер сортировки
   *
   * @param arr: Array[Data] - массив объектов типа Data
   * @return
   */
  def shaker_sort(arr: Array[Data]): Array[Data] = {
    var swapped = false
    do {
      def swap(i: Int): Unit = {
        val temp = arr(i)
        arr(i) = arr(i + 1)
        arr(i + 1) = temp
        swapped = true
      }

      swapped = false
      for (i <- 0 to (arr.length - 2)) if (arr(i) > arr(i + 1)) swap(i)

      if (swapped) {
        swapped = false
        for (j <- arr.length - 2 to 0 by -1) if (arr(j) > arr(j + 1)) swap(j)
      }
    } while (swapped)
    arr
  }

}
