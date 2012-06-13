
val PrimeDensity = 25

def findTheXPrime(x: Int): Int = {
  //guess a size
  val max = x * (PrimeDensity + 1)
  var numbers = new Array[Boolean](max + 2)
  for(i <- 2 to max + 1) numbers(i) = true

  var primeCount = 1
  var current = 2
  while(primeCount < x ){
    var prod = current 
    //blank out future non-primes
    while (prod <= max) {
      numbers(prod) = false 
      prod = prod + current
    }
    //Move to next free prime 
    while(!numbers(current) && current <= max) current += 1
    primeCount += 1
  }
  current
}
