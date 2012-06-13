
import scala.collection.mutable.ArrayBuffer
def getFactors(x: Int) : List[Int] = {
  var factors = new ArrayBuffer[Int]()
  for(y <- 1 to Math.sqrt(x)){
    if (x % y == 0){
      factors += y
      val s = Math.sqrt(x)
      if( s*s != x && y != 1){
        factors += x / y
      }
    }
  }
  factors.toList
}

def sum(x: List[Int]) : Int  = {
  if(x.isEmpty) return 0
  else x.head + sum(x.tail)
}

var s = 0

for (x <- 1 to 10000){
  val sof = sum(getFactors(x))
  if(x == sum(getFactors(sof)) && x != sof){
    println("Amicable: " + x + "/" + sof)
    s += x
  }
}
println("Sum: " + s)

