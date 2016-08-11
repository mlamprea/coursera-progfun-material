import scala.annotation.tailrec

def double(x: => Int): Int = 2 * x

def sum(f: Int => Int, a: Int, b: Int): Int = {
  if (a > b) 0 else
  f(a) + sum(f, a + 1, b)
}

def cube(x: Int): Int = x * x * x
def squared(x: Int): Int = x * x
def n(x:Int):Int = x


def sum_tail(f: Int => Int)(a: Int, b: Int): Int = {
  @tailrec def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a+1, acc+f(a))
  }
  loop(a, 0)
}


val f = (x:Int) => x*x
sum(f,1,5)

sum_tail((x:Int) => x*x)(1,5)



