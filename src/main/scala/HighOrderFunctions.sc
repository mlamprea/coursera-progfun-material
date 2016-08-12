import scala.annotation.tailrec

def double(x: => Int): Int = 2 * x

def sum(f: Int => Int, a: Int, b: Int): Int = {
  if (a > b) 0
  else
    f(a) + sum(f, a + 1, b)
}

def cube(x: Int): Int = x * x * x
def squared(x: Int): Int = x * x
def n(x: Int): Int = x


def sum_tail(f: Int => Int)(a: Int, b: Int): Int = {
  @tailrec def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a + 1, acc + f(a))
  }
  loop(a, 0)
}


val f = (x: Int) => x * x
sum(f, 1, 5)

sum_tail((x: Int) => x * x)(1, 5)

def product(f: Int => Int, a: Int, b: Int): Int = {
  if (a > b) 1 else f(a) * product(f, a + 1, b)
}

def product_tail(f: Int => Int, a: Int, b: Int): Int = {
  @tailrec def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else
      loop(a + 1, f(a) * acc)
  }
  loop(a, 1)
}


def factorial(n: Int): Int = {
  product_tail(x => x, 1, n)
}

val a = 1
val b = 7

product((x: Int) => x, a, b)
product_tail((x: Int) => x, a, b)
factorial(b)

def operation_tail(f: (Int, Int) => Int, g: Int => Int, a: Int, b: Int): Int = {
  @tailrec def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else
      loop(a + 1, f(g(a), acc))
  }
  loop(a, 1)
}


/*

val sum_tail = sum_tail((x: Int) => x)(a, b)
val sum_Operation_tail = operation_tail((x, y) => x + y, x => x, a, b)

val product_tail = product_tail((x: Int) => x, a, b)
val product_Operation_tail = operation_tail((x, y) => x * y, x => x, a, b)

*/

def abs(x:Int):Int = if(x>=0) x else -x

def operation(f: (Int, Int) => Int, g: Int => Int, a: Int, b: Int): Int = {
  if (a > b) abs(f(1,-1)) else f(g(a), operation(f, g, a + 1, b))
}

val sum_ = sum((x: Int) => x, a, b)
val sum_Operation = operation((x, y) => x + y, x => x, a, b)

val product = product_tail((x: Int) => x, a, b)
val product_Operation = operation((x, y) => x * y, x => x, a, b)

