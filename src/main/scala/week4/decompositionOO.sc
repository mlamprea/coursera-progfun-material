package week4

object decomposition {
  println("Descomposition Object Oriented Objects - touch all classes to add new method")
                                                  //> Descomposition Object Oriented Objects - touch all classes to add new method
                                                  //| 
  val sum1 = new Sum(new Number(1), new Number(2))//> sum1  : week4.Sum = week4.Sum@3ac3fd8b
  sum1.eval()                                     //> res0: Int = 3

}

trait Expr {
  def isNumber: Boolean
  def isSum: Boolean
  def numValue: Int
  def leftOp: Expr
  def rightOp: Expr
  def eval(): Int

}

class Number(n: Int) extends Expr {
  def isNumber = true
  def isSum = false
  def numValue = n
  def leftOp: Expr = throw new Error("Number.leftOp")
  def rightOp: Expr = throw new Error("Number.rightOp")
  def eval(): Int = n
}

class Sum(e1: Expr, e2: Expr) extends Expr {
  def isNumber = false
  def isSum = true
  def numValue = throw new Error("Sum.Number")
  def leftOp: Expr = e1
  def rightOp: Expr = e2
  def eval(): Int = e1.eval + e2.eval
}