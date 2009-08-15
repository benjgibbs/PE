
package utils

import scala.collection.mutable.ArrayBuffer

object PrimeFactor{
  def apply(p: Int, m: Int) = new PrimeFactor(p, m)
}

class PrimeFactor(p: Int, m: Int){
  val prime = p
  val multiplicity = m
  override def equals(rhs: Any) : Boolean = rhs match {
    case that : PrimeFactor => (prime == that.prime) && (multiplicity == that.multiplicity)
    case _ => false
  }
  override def toString() = p + "^" + m
}


object Utils {
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


  def primeFactors(of: Int, primes: List[Int]) : List[Int] = {
    if(primes.size == 0) Nil
    else if(of % primes.head == 0) primes.head :: primeFactors(of, primes.tail)
    else primeFactors(of, primes.tail)
  }

   def pow(x:Int,y:Int) : Int = Math.pow(x,y).toInt
  
  
  def bpf(o:Int, p:Int, f:Int) : Int =  {               
    if (o==pow(p,f)) f            
    else if(o%pow(p,f) == 0) bpf(o,p,f+1)
    else f-1
  }

  def primeFactorization(of: Int, primes: List[Int]) : List[PrimeFactor] =  {
    if(primes == Nil) Nil 
    else {
      val x = primes.head
      if (x==of) PrimeFactor(x,1) :: Nil
      else if ((of%x)  == 0) PrimeFactor(x, bpf(of,x,1)) :: primeFactorization(of/pow(x,bpf(of,x,1)), primes.tail)
      else primeFactorization(of, primes.tail) 
    }
  }

  def main(args: Array[String]) = {
    println("Starting tests...")
    val primes = findPrimes(100)
    assert(primes.contains(17))
    assert(primes.contains(13))
    assert(!primes.contains(6))

    assert(List(2) == primeFactors(2, primes))
    assert(List(2,3) == primeFactors(6, primes))
    assert(List(2,3) == primeFactors(12, primes))
    assert(List(2,3,5) == primeFactors(30, primes))
    assert(List(2,3,5) == primeFactors(60, primes))
    assert(List(2,3,5,7) == primeFactors(210, primes))
    assert(List(2,3,5,7) == primeFactors(420, primes))
    assert(PrimeFactor(2,1) == primeFactorization(2,primes).head)
    assert(PrimeFactor(2,3) == primeFactorization(8,primes).head)
    assert(PrimeFactor(2,10) == primeFactorization(1024,primes).head)
    assert(List(PrimeFactor(2,3)) == primeFactorization(8,primes))
    assert(List(PrimeFactor(2,1),PrimeFactor(3,1)) == primeFactorization(6,primes))
    assert(List(PrimeFactor(2,3), PrimeFactor(3,1)) == primeFactorization(24,primes))

    println("Tests finished.")
  }
}

