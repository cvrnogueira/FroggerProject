package frogger.screen.frame.elements.generics

import scala.collection.mutable

class GenericList[A] {
  var elements =  mutable.MutableList[A]()
  def restartCarPositionsList(): Unit = {
    elements = mutable.MutableList[A]()
  }
  def add(a: A): Unit ={
    elements += a
  }
  def restart(): Unit = {
    elements = mutable.MutableList[A]()
  }
}



