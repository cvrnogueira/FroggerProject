package frogger.screen.frame.elements.highOrderFunctions

object HighOrderFunctions {

  def id(x: Double): Double = x
  def sum(f: Double => Double, a: Double, b: Double, c:Double): Double =
    f(a) + sum(f, a , b,c)
}
