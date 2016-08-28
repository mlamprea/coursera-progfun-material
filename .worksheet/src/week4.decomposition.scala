package week4

object decomposition {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(127); 
  println("Descomposition Object Oriented Objects - touch all classes to add new method");$skip(51); 
  val sum1 = new Sum(new Number(1), new Number(2));System.out.println("""sum1  : week4.Sum = """ + $show(sum1 ));$skip(14); val res$0 = 
  sum1.eval();System.out.println("""res0: Int = """ + $show(res$0))}

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
