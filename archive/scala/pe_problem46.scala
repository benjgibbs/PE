import utils.Utils

val primes = Utils.findPrimes(50000) 

def isComposite(x: Long) : Boolean = !primes.contains(x)
def isOdd(x: Long) : Boolean = x % 2 == 1

def kHasFactorOfTwiceJSquared(k: Long, j: Long) : Boolean = {
  val l = j*j*2
  //println("k: "+k+", j: "+j+", l: "+l)
  if(l>k) false
  else if(l==k) true
  else kHasFactorOfTwiceJSquared(k,j+1)
}

def kHasFactorOfTwiceASquare(k: Long) : Boolean = kHasFactorOfTwiceJSquared(k,1) 


def isSumOfPrimeAndTwiceASquare(x: Long, ps: List[Int]) : Boolean = {
  //println("x: "+x+", Prime: "+ps.head)
  if(ps.head > x) false
  else if(kHasFactorOfTwiceASquare(x-ps.head)) true
  else isSumOfPrimeAndTwiceASquare(x, ps.tail)
}

def problem46(x: Long) : Unit =  {
  //println("Testing: " + x)
  if(isOdd(x) && isComposite(x) && 
    !isSumOfPrimeAndTwiceASquare(x,primes)) println("Found: " + x)
  else problem46(x+1)
}

problem46(2)


