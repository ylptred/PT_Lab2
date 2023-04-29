package sorting

import au.com.bytecode.opencsv.CSVWriter

import scala.io.BufferedSource
import java.io._
import java.io.{BufferedWriter, FileWriter}
import scala.collection.mutable.ListBuffer
import scala.jdk.CollectionConverters._
import scala.util.Random
import au.com.bytecode.opencsv.CSVWriter

import scala.io.BufferedSource

object Main {

  /**
   * Главный метод программы, содержит вызовы всех вспомогательных функций и замер времени выполнения сортировок
   *
   * @param args
   * @return
   */
  def main(args: Array[String]): Unit = {

    var time_shaker_arr: Map[String, String] = Map.empty[String, String]

    val selections: Array[String] = Array[String]("100", "500", "1000", "2500", "5000", "10000", "25000", "50000", "100000")

    utils.data.MakeCSV.generateData(selections)

    for (selection <- selections) {
      var data_arr: Array[Data] = Array.empty[Data]
      val data_source: BufferedSource = io.Source.fromFile(s"src/main/resources/gendata/$selection.csv")
      for (line <- data_source.getLines.drop(1)) {
        val splittedLine: Array[String] = line.split(",")
        val DataObject: Data = new DataClass(splittedLine(0), splittedLine(1).drop(1).dropRight(1).toInt,
          splittedLine(2).drop(1).dropRight(1).toInt,
          splittedLine(3).drop(1).dropRight(1).toInt)
        data_arr = data_arr :+ DataObject
      }
      data_source.close

      val outputFile: BufferedWriter = new BufferedWriter(new FileWriter(s"src/main/resources/sorteddata/shaker_$selection.csv"))
      val csvWriter: CSVWriter = new CSVWriter(outputFile)

      val shaker_arr: Array[Data] = utils.sort.Sort.shaker_sort(data_arr)

      var shaker = new ListBuffer[Array[String]]
      for (elem <- shaker_arr) {
        shaker += Array(elem.serviceName, elem.deadline.toString, elem.price.toString, elem.subprice.toString)
      }
      csvWriter.writeAll(shaker.toList.asJava)
    }




  }
}
