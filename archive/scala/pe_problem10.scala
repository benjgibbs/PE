

//1179908154

def sumPrimes(under: Int) = {
  var sum = 0L
  for (x <- findPrimes(under-1)){
    sum += x.toLong
  }

  println("Sum of primes under " + under + " is: " + sum)
}


