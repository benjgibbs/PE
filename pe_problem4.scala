
def isPalindromic(p: Int, q: Int) : Boolean = {
  val x = p*q
  if(x < 1000000 && x > 99999){
    val a = x / 100000 
    val b = x / 10000 - (a*10)
    val c = x / 1000 - (a*100 + b*10)
    val d = x / 100 - (a*1000 + b*100 + c*10)
    val e = x / 10 - (a*10000 + b*1000 + c*100 + d*10)
    val f = x / 1 - (a*100000 + b*10000 + c*1000 + d*100 + e*10)
    
    //println("a: " + a + ", b: " + b + ", c: " + c + ", d: " + d + ", e: " + e + ", f: " + f + ".")

    a == f && b == e && c == d
  }
  else{
    //println(x + ": Wrong size(" + p + "/" + q + ").")
    false
  }
}

var biggest = 0
val max = 999
for (i <- max to 100 by -1){
  for (j <- max to 100 by -1){
    if(isPalindromic(i,j)){
      val product = i*j
      if(product > biggest){
        println("Palindromic: " + i + ", " + j + ": " + i*j)
        biggest = product
      }
    }
  }
}

