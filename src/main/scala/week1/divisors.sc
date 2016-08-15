def max_div(a: Int, b: Int): Int =
  if (b == 0) a else max_div(b, a % b)

def max_div_count(a: Int, b: Int, count: Int): (Int,Int) =
  if (b == 0) (a,count) else max_div_count(b, a % b, count + 1)

max_div(14, 21)
max_div(21, 14)
max_div(989876658, 232344432)

max_div_count(14, 21,0)
max_div_count(21, 14,0)
max_div_count(100999, 2322789,0)