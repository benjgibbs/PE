
// Problem 1
def sum(x: Int) = {
  var total = 0
  for (i <- 1 to x)
    if( i%3 == 0 || i%5 ==0)
      total += i
  println(total); 
}
