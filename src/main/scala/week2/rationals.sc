val x = new Rational(999999999, 999999999)
val y = new Rational(1, 2)
val z = new Rational(2, 2)
z & (y)
y & (z)
//val strange = new Rational(1,0)
//strange.add(strange)
val integer = new Rational(2)
x.add(x).add(x).add(x).add(x).add(x).add(x).add(x).add(x).add(x).add(x).add(x).add(x).add(x).add(x).add(x).add(x)


class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be nonzero")

  def this(x: Int) = this(x, 1)

  def max_div(a: Int, b: Int): Int =
    if (b == 0) a else max_div(b, a % b)

  def numer = x

  def denom = y

  def neg = new Rational(-numer, denom)

  def &(that: Rational) = numer * that.denom < that.numer * denom

  def add(that: Rational): Rational =
    new Rational((numer * that.denom + that.numer * denom), (denom * that.denom))

  def sub(that: Rational) = add(that.neg)

  override def toString = {
    val g = max_div(x, y)
    numer / g + "/" + denom / g
  }
}


