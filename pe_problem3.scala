//170


def searchForFactors(toFactor: Long, primes: List[Int]) : List[Long] = {
  println("Checking: " + toFactor)

  var factors = List[Long]()
  
  for (x <- primes){
    if(toFactor % x == 0L){ 
      val y = toFactor / x
      println(x + " divides " + toFactor + ": " + y)
      
      val primeFactor = primes.find(p => p == y )

      if(primeFactor.isEmpty){
        println("Possibly prime: " + y + ". Recursing search")
        val x = searchForFactors(y, primes)
        if (x.isEmpty)
          println("__IS__PRIME__")
        else
          factors = factors ::: x
      }
      else {
        println("Factor: " + x)
        factors = factors ::: List[Long](x)
      }
    }
  }
  factors
}

val toFind = 600851475143L
val sqrt = Math.sqrt(toFind).intValue()
println("Max prime is: " + sqrt);
val primes = findPrimes(sqrt)
val factors = searchForFactors(toFind, primes)

println("\n\nFactors: " + factors.sort((a,b) => a<b))

