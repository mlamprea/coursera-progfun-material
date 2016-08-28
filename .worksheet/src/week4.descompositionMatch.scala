package week4
object descompositionMatch {
}

trait ExprMatch {

  case class Sum(e1: ExprMatch, e2: ExprMatch) extends ExprMatch

  class Number(n: Int) extends ExprMatch
}
