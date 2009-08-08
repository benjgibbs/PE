import euler.FindPrimes

val LIMIT = 1000000
//val LIMIT = 1000
val x = FindPrimes.findPrimes(LIMIT)
val lastIdx = x.length - 1

var longest = 0
var startIdx = 0
while(startIdx < lastIdx) {
  var sum = 0L 
  var curIdx = startIdx
  while(curIdx < lastIdx &&  sum < LIMIT){
    sum = sum + x(curIdx)
    val termCount = curIdx - startIdx + 1
    if((termCount > longest) && x.contains(sum)){
      println("New longest: " + sum + " Term Count: " + termCount) 
      longest = termCount
    }
    curIdx = curIdx + 1
  }
  startIdx += startIdx + 1
}

