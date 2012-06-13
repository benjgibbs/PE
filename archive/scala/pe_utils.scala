
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
      if (x==of) 
        PrimeFactor(x,1) :: Nil
      else if ((of%x)  == 0) 
        PrimeFactor(x, bpf(of,x,1)) :: primeFactorization(of/pow(x,bpf(of,x,1)), primes.tail)
      else 
        primeFactorization(of, primes.tail) 
    }
  }
    
  def swap[T](x:Array[T], i:Int, j:Int) : Array[T] = {
    val t = x(i)
    x(i) = x(j)
    x(j) = t
    x
  }

  def fac(x: Int) : Int =  {
    if(x == 0) 1
    else x * fac(x-1)
  }

  def arrayToInt(x: Array[Int], k: Int) : Int = {
    if(x.size ==0) 0
    else x(x.size-1) * pow(10,k) + arrayToInt(x.take(x.size-1), k+1)
  }

  def allPermsOfDigits(x:Int)={
    for(k <- allPerms(x.toString.toArray.map(_.toString.toInt)))
      yield arrayToInt(k,0)
  }

  def allPerms[T](x: Array[T]) = {
    for (a <- 0 to fac(x.length)-1) 
      yield permutation(a,x)
  }
  
  def permutation[T](k: Int, y:Array[T]) : Array[T] = {
    var result = new Array[T](y.size)
    Array.copy(y,0,result,0,y.size)
    
    var seed = k
    for(loop <- 2 to result.length){
      swap(result, (seed % loop), loop-1)
      seed = seed / loop 
    }
    result
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
    
    assert(Array(1,2,4,3).deepEquals(swap(Array(1,2,3,4),2,3)))
    
    assert(allPermsOfDigits(123).size == 6)
    
   for (i <- 1 to 15){
     println(i)
     println(permutation(i, Array(1,4,8,7)))
   }


    println("Tests finished.")
  }
}

