

def sumOfSquares(x: Int) : Long = {
  var result = 0
  for ( y <- 1 to x)
    result += y*y
  result
}

def squareOfSum(x: Int) : Long = {
  var result = 0
  for(y<-1 to x)
    result += y
  result * result
}

val MAX = 100
val x = sumOfSquares(MAX)
val y = squareOfSum(MAX)
println("Difference: " + (y - x))
