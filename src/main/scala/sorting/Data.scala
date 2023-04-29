package sorting

/**
 * Трейт (интерфейс) Data
 *
 * @param serviceName: String - Название услуги
 * @param price: Int - Стоимость услуги в рублях
 * @param deadline: Int - Срок выполнения услуги в днях
 * @param subprice: Int - Размер предоплаты в рублях
 * @return
 */
trait Data {

  val serviceName: String
  val price: Int
  val deadline: Int
  val subprice: Int


  /**
   * Метод перегрузки операции <
   *
   * @param that - Объект типа Data, является правым операндом
   * @param this - Объект типа Data, является левым операндом
   * @return
   */
  def <(that: Data): Boolean = {
    if (this.serviceName < that.serviceName) {
      true
    } else if (this.serviceName == that.serviceName) {
      if (this.price < that.price) {
        true
      } else if (this.price == that.price) {
        if (this.subprice < that.subprice) {
          true
        } else {
          false
        }
      } else {
        false
      }
    } else {
      false
    }
  }

  /**
   * Метод перегрузки <=
   *
   * @param that - Объект типа Data, является правым операндом
   * @param this - Объект типа Data, является левым операндом
   * @return
   */
  def <=(that: Data): Boolean = {
    (this < that) || (this.serviceName == that.serviceName && this.price == that.price && this.subprice == that.subprice)
  }

  /**
   * Метод перегрузки >
   *
   * @param that - Объект типа Data, является правым операндом
   * @param this - Объект типа Data, является левым операндом
   * @return
   */
  def >(that: Data): Boolean = {
    !(this <= that)
  }

  /**
   * Метод перегрузки >=
   *
   * @param that - Объект типа Data, является правым операндом
   * @param this - Объект типа Data, является левым операндом
   * @return
   */
  def >=(that: Data): Boolean = {
    !(this < that)
  }
}

/**
 * Класс DataClass, унаследованный от Трейта Data
 *
 * @param serviceName: String - Название услуги
 * @param price: Int - Стоимость услуги в рублях
 * @param deadline: Int - Срок выполнения услуги в днях
 * @param subprice: Int - Размер предоплаты в рублях
 * @return
 */
class DataClass(val serviceName: String, val price: Int, val deadline: Int, val subprice: Int) extends Data
