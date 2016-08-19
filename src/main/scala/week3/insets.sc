val t1 = new NonEmpty(5, new Empty, new Empty)
val t12 = t1 incl 10
val t13 = t12 incl 1
t13 contains 5
t13 contains 10
t13 contains 1

val t2 = new NonEmpty(1000, new Empty, new Empty)
val t21 = t2 incl 20000
val t22 = t2 incl 20
val t13_union_t22 = t13 union t22
val t22_union_t13 = t22 union t13

abstract class IntSet {
  def incl(x: Int): IntSet

  def contains(x: Int): Boolean

  def union(other: IntSet): IntSet
}

class Empty extends IntSet {
  def incl(x: Int): IntSet = new NonEmpty(x: Int, new Empty, new Empty)

  def contains(x: Int): Boolean = false

  override def toString = "."

  def union(other: IntSet): IntSet =
    other
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def incl(x: Int): IntSet = {
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  }

  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def union(other: IntSet): IntSet =
    ((left union right) union other) incl elem

  override def toString = "{" + left + elem + right + "}"
}