package com.scalakml.example

import com.scalakml.io.{KmlPrintWriter, KmlFileReader}
import xml.PrettyPrinter
import com.scalakml.kml._
import com.scalakml.kml.FeaturePart
import com.scalakml.kml.Point
import com.scalakml.kml.Placemark
import scala.Some

/**
 * Author: Ringo Wathelet
 * Date: 23/01/13 
 * Version: 1
 */

object WriteExample1 {
  def main(args: Array[String]): Unit = {
    println("....WriteExample1 start...\n")
    // create a Point at a location
    val point = Point(coordinates = Some(Seq.empty :+ new Location(151.21037, -33.8526)))
    // create a Placemark with the point, a name and open
    val placemark = Placemark(Some(point), FeaturePart(name = Some("Sydney, OZ"), open = Some(true)))
    // create a kml root object with the placemark
    val kml = Kml(feature = Some(placemark))
    // write the kml to the output file
    new KmlPrintWriter("./kml-files/Sydney-oz.kml").write(Option(kml), new PrettyPrinter(80, 3))
    println("\n....WriteExample1 done...")
  }
}