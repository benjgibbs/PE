
import scala.collection.mutable.ArrayBuffer

def findPrimes(max : Int): List[Int] = {
  var numbers = new Array[Boolean](max + 2)
  for(i <- 2 to max + 1) numbers(i) = true

  var primes = new ArrayBuffer[Int]()
  var current = 2
  while(current <= max){
    primes += current
    var prod = current 
    while (prod <= max) {
      numbers(prod) = false 
      prod = prod + current
    }
    
    while(!numbers(current) && current <= max) current += 1
  }
  primes.toList
}
