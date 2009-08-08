
//837799
def iterate(start: Int): Int ={
  var p = start.toLong
  var c = 0 
  while (p != 1) {
    c += 1
    if (p % 2 == 0)
      p = p/2
    else
      p = 3*p + 1
  }
  c
}

def run() ={
  var longestSoFar = 0

  for(x <- 1 to 1000000){
    var c = iterate(x)
    if(c > longestSoFar){
      println("Longest so far: " + c + ". Produced by: " + x)
      longestSoFar = c
    }
  }
}

run()
