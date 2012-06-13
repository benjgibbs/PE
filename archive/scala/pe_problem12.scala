
import scala.collection.mutable.ArrayBuffer

def countFactors(x: Int) : Int = {
  var numFactors = 0
  for(y <- 1 to Math.sqrt(x))
    if (x % y == 0) numFactors += 1
  numFactors *= 2
  val s = Math.sqrt(x)
  if( s*s == x) numFactors -= 1
  numFactors
}

def getFators(x: Int, n: Int) : List[Int] = {
  var a = new Array[Int](n)
  var pos = 0
  for(y <- 1 to x){
    if (x % y == 0) {
      a(pos) = y
      pos += 1
    }
  }
  a.toList
}

val start = System.currentTimeMillis()
val targetFactors = 500
var numFactors = 0
var i = 0
var triangleNum = 0
while (numFactors < targetFactors){
  i += 1
  triangleNum += i
  numFactors = countFactors(triangleNum)
}
val stop = System.currentTimeMillis()
println(triangleNum + " has " +  numFactors + " factors. (" + i + "). Took " + ((stop - start)/1000f)) //=> " + getFators(triangleNum, numFactors))

