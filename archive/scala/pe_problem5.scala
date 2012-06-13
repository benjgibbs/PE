

//232792560

var MAX = 20 

def divisibleBy1toMax(x: Long) : Boolean = {
  for(d <- 2 to MAX){
    if(x % d != 0L){
      return false
    }
  }
  true
}

var increment = 1

for (x <- findPrimes(MAX))
 increment = increment * x

var found = false
var x = increment.toLong

while(!found && x < java.lang.Long.MAX_VALUE){
  x = x + increment.toLong
  if(divisibleBy1toMax(x)){
      println("\nDivsible by 1 through " + MAX + ": " + x)
      found = true
  }
}

