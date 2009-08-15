import utils.Utils
import utils.PrimeFactor

val primes = Utils.findPrimes(1000)
var cont = true
var x = 1

val RUN = 4

while(cont){
  
  var factorsSzOk = true
  var factorsList : List[PrimeFactor] = Nil 
  for(i <- 0 to RUN-1) {
    val factors = Utils.primeFactorization(x+i,primes)
    if(factors.size != RUN) factorsSzOk = false
    else factorsList = factorsList ::: factors 
  }
  if(factorsSzOk && factorsList.size == RUN*RUN){
    cont = false
    for( k <- 0 to RUN-1)
      println( (x+k) + " Factors " + Utils.primeFactorization(x+k, primes))
  }
  x += 1
}

