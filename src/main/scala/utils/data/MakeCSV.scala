package utils.data

import java.io.{BufferedWriter, FileWriter}
import scala.collection.mutable.ListBuffer
import scala.jdk.CollectionConverters._
import scala.util.Random
import au.com.bytecode.opencsv.CSVWriter

import scala.io.BufferedSource

object MakeCSV {

  /**
   * Метод генерации данных для сортировки
   *
   * @param selections: Array[String] - массив, содержащий объемы выборок данных, которые необходимо сгенерировать
   * @return
   */
  def generateData(selections: Array[String]): Unit = {

    for (select <- selections) {
      val outputFile: BufferedWriter = new BufferedWriter(new FileWriter(s"src/main/resources/gendata/$select.csv"))
      val csvWriter: CSVWriter = new CSVWriter(outputFile)
      val csvFields: Array[String] = Array[String]("Название Услуги", "Ориентировочная Стоимость", "Срок Исполнения",
        "Размер Предоплаты")
      var servicesListTMP: Array[String] = Array.empty[String]
      val services_source: BufferedSource = io.Source.fromFile("src/main/resources/origdata/services.csv")
      for (line <- services_source.getLines.drop(1)) {
        servicesListTMP = servicesListTMP :+ line
      }
      var servicesList: Array[String] = Array.empty[String]
      val counter: Int = select.toInt / servicesListTMP.length
      val diff: Int = select.toInt - (counter * servicesListTMP.length)
      for (_ <- 1 to counter) {
        for (elem <- servicesListTMP) {
          servicesList = servicesList :+ elem
        }
      }
      for (num <- 0 until diff) {
        servicesList = servicesList :+ servicesListTMP(num)
      }
      services_source.close
      var prices: Array[Int] = Array.empty[Int]
      for (_ <- 1 to select.toInt) {
        val value: Int = Random.between(100000, 10000000)
        prices = prices :+ value
      }
      var subprices: Array[Int] = Array.empty[Int]
      for (num <- prices) {
        val value: Int = num.toInt / Random.between(2, 4)
        subprices = subprices :+ value
      }
      var deadlines: Array[Int] = Array.empty[Int]
      for (_ <- 1 to select.toInt) {
        deadlines = deadlines :+ Random.between(14, 365)
      }
      var listOfRecords = new ListBuffer[Array[String]]()
      listOfRecords += csvFields
      for (i <- 0 until select.toInt) {
        listOfRecords += Array(servicesList(i), prices(i).toString, deadlines(i).toString, subprices(i).toString)
      }
      csvWriter.writeAll(listOfRecords.toList.asJava)
      outputFile.close()

      println(s"[DONE]: selection $select")
    }
  }
}


