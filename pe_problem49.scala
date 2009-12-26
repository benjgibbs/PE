import utils.Utils

val primes = Utils.findPrimes(10000).filter( _ > 999)
var done = List[Int]()

for(p <- primes) {
  if(!done.contains(p)) {
  
    val primePerms = (for(q <- Utils.allPermsOfDigits(p).toList.removeDuplicates;                           if(primes.contains(q))) yield q).sort(_<_)
    
    done = done ::: primePerms

    for(i <- primePerms; j <- primePerms.dropWhile(_ != i).tail){
      val distance : Int = Math.abs(i-j)
      val k = i+2*distance;
      if(primePerms.contains(k))
        println(i + "," + j + "," + k + " have distance of " + 
          distance + ". " + i+j+k)
    }
  }
}

