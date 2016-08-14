def abs(x: Double) = if (x >= 0) x else -x
val tolerance = 0.0001
def isCloseEnough(x: Double, y: Double) = abs((x - y) / x) / x < tolerance
def fixedPoint(f: Double => Double)(firstGuess: Double) = {
  def loop(guess: Double, iterations: Int): (Double, Double) = {
    //  println("Guess -> "+guess)
    if (isCloseEnough(guess, f(guess))) (guess, iterations) else loop(f(guess), iterations + 1)
  }
  loop(firstGuess, 1)
}

fixedPoint(x => 1 + x / 2) (0.0001)
def square(x: Double) = fixedPoint(y => (y + x / y) / 2)(1.0)

def averageDamp(f: Double => Double)(x: Double):(Double => Double) =
  x => (x + f(x)) / 2

def root(x:Double)={
  fixedPoint(averageDamp(y => (y+x/y)/2)(x))(1)
}

root(81)
