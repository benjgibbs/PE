
import scala.collection.mutable.ArrayBuffer
object P24
{
  def printArray(x: Array[Int]) = {
    x.foreach(print(_))
    println("")
  }

  // x ^ ye
  def pow(x: BigInt, y: BigInt) : BigInt =  {
    if (y == 0) 1
    else x * pow(x, y-1)
  }

  def munch(x: BigInt, f: BigInt) : Int = {
    val f1 = pow(10,f+1)
    val f2 = pow(10,f)
    val d = pow(10,f)
    (((x % f1) - (x % f2))/d).intValue
  }

  def next(i: Int) : Int = {i-1}

  def toArray(x: BigInt) : Array[Int] = {
    val max = 10
    var a = new Array[Int](max)
      (1 to max).foreach(k=>{
        a(max-k) = munch(x,k-1)
      })
    a
  }
  def sort(b: Array[Int]) : Array[Int] = {
    ((b toList) sort(_<_)).toArray
  }

  def nextBiggestAt(biggerThan: Int, array: Array[Int]) : Int = {
    var x = 0
    while(array(x) < biggerThan) x+=1
    x
  }

  def shuffle(buffer: Array[Int], data: Array[Int],  idx: Int) : List[Int] = {
    val nxtVal  = data(next(idx))
    val biggestIdx = nextBiggestAt(nxtVal,buffer)
    data(next(idx)) = buffer(biggestIdx) 
    buffer(biggestIdx) = nxtVal
    sort(buffer).toList
  }

  def run(x: Array[Int]): Unit = {
      val end = x.length-1
      var i = end
      var cnt = 1
      while(i > 0 && cnt < 1000000){
        if(x(i) > x(next(i))) {
          var buffer = new ArrayBuffer[Int]()
          for(k<-i to end) buffer += x(k)
          var toAdd = shuffle(sort(buffer.toArray), x, i)
          for(j<-i to end){
            x(j) = toAdd.head
            toAdd = toAdd.tail
          }
          i = end
          cnt += 1
        }
        else{
          i -= 1
        }
      }
  }

  def main(args: Array[String]) = {
    val test = toArray(123456789)
    printArray(test)
    val start = System.currentTimeMillis();
    run(test)
    val end = System.currentTimeMillis();
    printArray(test)
    println("Took: " + (end - start) + " ms.");
  }
}



// x ^ ye
// def pow(x: BigInt, y: BigInt) : BigInt =  {
//   if (y == 0) 1
//   else x * pow(x, y-1)
// }
// 
// //scala> for(x <- 0 to 9)print(valAtPos(12345,x)+",")
// //5,4,3,2,1,0,0,0,0,0,
// def valAtPos(test: BigInt, pos: BigInt) : BigInt = {
//   val m = pow(10,pos)
//   val x = test % (m*10)
//   x / m
// }
// 
// val max = 30
// val positions = 9
// var counter = 0
// var trial = BigInt(123456789)
// 
// def duplicated(toCheck: BigInt) : Boolean = {
//   for(x <- 0 to positions) {
//     val vX = valAtPos(toCheck,x)
//     for(y <- (x+1) to positions){
//       if(vX == valAtPos(toCheck, y))
//         return true
//     }
//   }
//   false
// }
// 
// while(counter < max){
//   if(!duplicated(trial)){
//     //println("Match number " + counter +" is " + trial) 
//     for(j<-0 to 9)
//       if(valAtPos(trial,j) == 7) 
//         print(j+",")
//     counter += 1
//   }
//   trial += 1
// }
// 
// println("Positions: " + trial);

// 9s Position
// 0,1,0,1,2,2,0,1,0,1,2,2,0,1

// Match number 0 is 123456789
// Match number 1 is 123456798
// Match number 2 is 123456879
// Match number 3 is 123456897
// Match number 4 is 123456978
// Match number 5 is 123456987
// Match number 6 is 123457689
// Match number 7 is 123457698
// Match number 8 is 123457869
// Match number 9 is 123457896
// Match number 10 is 123457968
// Match number 11 is 123457986
// Match number 12 is 123458679
// Match number 13 is 123458697
// Match number 14 is 123458769



