
def isTriplet(a: Int, b: Int, c: Int) : Boolean = {
  a*a + b*b == c*c
}

def sumsTo1k(a: Int, b: Int, c: Int){
  1000 == (a + b + c)
}

for (j <- 1 to 998){
  for (k <- 1 to (999 - j)){
    val l = 1000 - (j + k)
    if(isTriplet(j,k,l)){
      println("Triplet exists: " + j + ", " + k + ", " + l + ".  Product is: " + j * k * l)
    }
  }
}
