package week4

object descompistionMatch {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(133); 
  println("Descompisition Pattern Match is similar to OO but use a single object to eval");$skip(58); 
  val sumMatch = new Sum1(new Number1(1), new Number1(2));System.out.println("""sumMatch  : <error> = """ + $show(sumMatch ));$skip(18); val res$0 = 
  sumMatch.eval();System.out.println("""res0: <error> = """ + $show(res$0))}
  
  
}

trait ExprMatch {

  case class Sum1(e1: ExprMatch, e2: ExprMatch) extends ExprMatch
  case class Number1(n: Int) extends ExprMatch

  def eval(): Int = this match {
    case Number1(x) => x
    case Sum1(l, r) => l.eval + r.eval
  }
}
