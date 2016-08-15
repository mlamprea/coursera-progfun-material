val x = new Rational(1, 2)
val y = new Rational(1, 2)
val z = new Rational(2, 2)

x.add(y).add(z)

class Rational(x: Int, y: Int) {
  def numer = x

  def denom = y

  def neg = new Rational(-numer, denom)

  def add(that: Rational): Rational =
    new Rational((numer * that.denom + that.numer * denom), (denom * that.denom))

  def sub(that: Rational) = add(that.neg)

  override def toString = numer + "/" + denom

}
