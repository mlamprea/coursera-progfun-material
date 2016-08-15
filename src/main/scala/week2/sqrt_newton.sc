def abs(x: Double) = if (x < 0) -x else x

def sqrt_n(guess: Double, x: Double): Double =
  if (isGoodEnough(guess, x))  guess
  else sqrt_n(improve(guess, x), x)


def isGoodEnough(guess: Double, x: Double): Boolean =
  abs(guess * guess - x) /x<= 0.0001

def improve(guess: Double, x: Double) =
  (guess + x / guess) / 2


def sqrt(x:Double) = sqrt_n(3,x)


sqrt(0.001)
math.sqrt(0.001)

sqrt(0.1e-20)
math.sqrt(0.1e-20)






