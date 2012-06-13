import scala.io.Source

val nums = for { 
    i <- Source.fromFile("cipher1.txt").getLines 
    j <- i.stripLineEnd.split(',').elements } 
        yield j.toInt


val threeLetterWords = for {
    i <- Source.fromFile("/usr/share/dict/words").getLines
    if i.stripLineEnd.length == 3  }
        yield i.stripLineEnd

def len[T](xs : List[T]) : Int = xs match {
    case Nil => 1
    case _ => 1 + len(xs.tail) 
}

println("Num Three Letter Words: " + len(List.fromIterator(threeLetterWords)))



/*
var chars = Map[Int,Int]()

for(i <- nums) chars = chars + (i -> (if (chars.contains(i)) (chars(i) + 1) else 1))


var max = 0
for(c <-chars){
  if(c._2 > max) {
    max = c._2
    println("New most common: " + c._1 + " occurs " + max)
  }
}
*/   


/*def extractPoints(xs : List[Int]) : List[(Int,Int,Int)] =  xs match {
  case x :: y :: z :: rest => (x,y,z) :: extractPoints(xs.tail)
  case x  => Nil
}

var tripples = Map[(Int,Int,Int), Int]()

for (n <- extractPoints(nums.toList)) {
    tripples = tripples + (n ->
        (if(tripples.contains(n)) (tripples(n) + 1)
        else 1))
}

var occurs = 0
var decode = (0,0,0) 
  
for(t <- tripples){
  
  println(t._1._1.toChar + ", " + t._1._2.toChar + ", " + t._1._3.toChar)
  if(t._2 > occurs) {
    occurs = t._2
    decode = t._1
    println("New max of " + occurs + " at " + decode)
  }
}
*/



