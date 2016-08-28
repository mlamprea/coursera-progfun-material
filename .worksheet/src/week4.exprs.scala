package week4

object exprs{

}



trait Expr {
  def isNumber: Boolean
  def isSum: Boolean
  def numValue: Int
  def leftOp: Expr
  def rightOp: Expr
  //def eval(): Int Solution A
  def eval(e: Expr): Int = e match {
    case Number(x) => x
    case Sum(l, r) => eval(l) + eval(r)
  }
}

 class Number(n: Int) extends Expr {
  def isNumber = true
  def isSum = false
  def numValue = n
  def leftOp: Expr = throw new Error("Number.leftOp")
  def rightOp: Expr = throw new Error("Number.rightOp")
  //def eval(): Int = n Solution A
}

case class Sum(e1: Expr, e2: Expr) extends Expr {
  def isNumber = false
  def isSum = true
  def numValue = throw new Error("Sum.Number")
  def leftOp: Expr = e1
  def rightOp: Expr = e2
  //def eval(): Int = e1.eval + e2.eval Solution A
}
