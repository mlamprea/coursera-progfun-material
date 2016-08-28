package week4

object patternsAndMatch  extends App{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(165); 
def show(e :Expr):String = e match {
  case Number(x) => x.toString
  case Sum(l,r) =>	show(l)+" + "+show(r)
  };System.out.println("""show: (e: week4.Expr)String""")}
}
