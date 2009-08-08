import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Set


def sum(l: List[Int]): Int = {
  if(l.isEmpty) 0
  else l.head + (sum(l.tail))
}


def divisors(x: Int) : List[Int] = {
  val result = new ArrayBuffer[Int]()
  result += 1
  for (p <- 2 to Math.sqrt(x)){
    if((x%p) == 0){
      result += p
      val q = x/p
      if(p!=q) result += q
    }
  }
  result.toList
}

def isAbundant(x: Int) : Boolean= {
  x < sum(divisors(x))
}
  
println("12: " + divisors(12) + ", " + sum(divisors(12)))
println("4: " + divisors(4) + ", " + sum(divisors(4)))
/*val a = Set[Int]()
var d = false
for (x <- 1 to 28123){
  if(isAbundant(x)){
    if(!d){
      val y = divisors(x)
      println(x + " is abundant: " + sum(y) + ", " + y)
      d = true
    }
      
    a += x
  }
}*/


