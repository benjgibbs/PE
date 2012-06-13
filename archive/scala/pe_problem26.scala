
import scala.collection.mutable.Set

def eulerHcf(x: Long, y: Long) : Long = {
  if(y == 0)x
  else eulerHcf(y, x%y)
}

def power(x: Long, pow: Long) : Long = {
  if(pow==0) 1L
  else x * power(x, pow-1)
}

//def power(x: Double, pow: Long) : Double = {
//  if(pow==0) 1.0
//  else x * power(x, pow-1)
//}

def firstDigit(x:Long) : Long = {
  if(x%10 != 0 && x < 10) x
  else firstDigit(x/10)
}

def magnitude(x: Long) : Long = {
  if(x < 10) 1
  else 1 + magnitude(x/10)
}

def div(toDiv: Long, by: Long, carry: Long) : Unit = {
  val eval = firstDigit(toDiv) + carry*10
  val toSub = firstDigit(toDiv)*power(10L,magnitude(toDiv)-1)
  val remainder  = toDiv-toSub
  print(eval/by)
  if(remainder > 0){
    div(remainder,by,eval%by)
  }
}


//var greatest = 0

//for(j <- 1 to 1000) {
//  var found = false
//  for (i <- 1 to 20) {
//    val x : Double = 1.0/j
//    if(!found){
//      val k = power(10,i)*x-x
//      val l = k.toInt
//      if(k-l == 0){
//        found = true
//        if(i > greatest){
//          println("1/"+ j + "("+x+") repeats every " + i)
//          greatest = i
//        }
//      }
//    }
//  }
//}
//
//


//val recur(test: Double, places: int) : Double = {
//  val x = power(places, 10) * test
//  x
//}



//var biggestCycle = 0
//var counted = List[Int]()
//for(d <- 1 to 999){
//  for (cycleLen <- 1 to 20){
//    val frac : Double = 1.0/d
//    val shuffle = Math.pow(10,cycleLen)
//    val move = frac*shuffle
//    val intPart  : BigInt = move.toBigInt
//    val remPart = move - intPart
//    // println("Fac: " + frac + ", Move: " + move + ", Move2: " + remPart) 
//    if(!counted.contains(d) && intPart != 0){
//      if (intPart == (remPart*shuffle)){
//        if(cycleLen >= biggestCycle && !counted.contains(d)) {
//          println(d +"(" +cycleLen +"): " + frac + " repeating part " + intPart)
//          biggestCycle = cycleLen
//          counted = d :: counted
//        }
//      }
//    }
//  }
//}
