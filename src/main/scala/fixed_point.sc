def abs(x:Double) = if (x >= 0) x else -x
val tolerance = 0.0001
def isCloseEnough(x: Double, y: Double) =  abs((x-y)/x)/x < tolerance
def fixedPoint(f:Double => Double)(firstGuess:Double)={
  def loop(guess:Double, iterations:Int):(Double, Double)={
    if(isCloseEnough(guess,f(guess))) (guess,iterations) else loop(f(guess), iterations+1)
  }
  loop(firstGuess,1)
}
val p = fixedPoint((x:Double) => 1+(x/2))(1.0)


