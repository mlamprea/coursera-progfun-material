def loop(n: Int): Int =
  loop(n - 1)

def factorial(n: Int): Int =
  if (n == 0) 1 else n * factorial(n - 1)

def factorial_tr(n: Int): Int = {
  def loop(acc: Int, n: Int): Int = {
    if (n == 0) acc
    else loop(acc * n, n - 1)
  }
  loop(1,n)
}

factorial_tr(4)
