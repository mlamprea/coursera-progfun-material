package week4

object descompistionMatch {
  println("Descompisition Pattern Match is similar to OO but use a single object to eval")
  val sumMatch = new Sum1(new Number1(1), new Number1(2))
  sumMatch.eval()
  
  
}

trait ExprMatch {

  case class Sum1(e1: ExprMatch, e2: ExprMatch) extends ExprMatch
  case class Number1(n: Int) extends ExprMatch

  def eval(): Int = this match {
    case Number1(x) => x
    case Sum1(l, r) => l.eval + r.eval
  }
}