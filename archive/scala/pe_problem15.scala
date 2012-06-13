

def fact(x:BigInt) : BigInt = {
  if(x == 1) return 1
  else return x * fact(x-1)
}

for (gridSz <- 1 to 20) {
  val n = 2 * gridSz
  val k = gridSz
  val c = (fact(n))/(fact(k)*(fact(n-k)))
  println("For a grid of " + gridSz + "x" + gridSz + " there are " + c + " ways.") 
}

// D=> 1, R=>0
// 0011
// 0101
// 0110
// 1001
// 1010
// 1100
