trait List[T] {
  def head: T

  def tail: List[T]

  def isEmpty: Boolean
}

class Nil[T] extends List[T] {
  def head: Nothing = throw new NoSuchElementException("Nil.head")

  def tail: Nothing = throw new NoSuchElementException("Tail.head")

  def isEmpty = true

  override def toString = "Nil"

}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false

  override def toString = head + " " + tail
}

def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])

val l1 = singleton("1a")

def nth[T](n: Int, list: List[T]): T = {
  if (n == 0) list.head
  else nth(n - 1, list.tail)
}

val l2 = new Cons[String]("1b", new Cons[String]("1c", new Cons[String]("1d", new Nil[String])))
l2
nth[String](0, l2)
nth[String](1, l2)
nth[String](12, l2)
