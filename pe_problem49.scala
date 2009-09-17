import utils.Utils

val primes = Utils.findPrimes(10000).filter( _ > 999)
var done = List[Int]()

for(p <- primes) {
  if(!done.contains(p)) {
  
    val k = (for(q <- Utils.allPermsOfDigits(p).toList.removeDuplicates;      
                if(primes.contains(q))) yield q).sort(_<_)
    done = done ::: k

    for(i <- k; j <- k.dropWhile(_ != i).tail){
      val distance : Int = Math.abs(i-j)
      
      val l = i+2*distance;
      if(k.contains(l))
        println(i + "," + j + "," + l +
          " have distance of " + distance + ". " + i+j+l)
    }
  }
}

