

object Problem56 {
  def sumDigits(toSum: BigInt) : BigInt = {
    if(toSum != 0) (toSum % 10) + sumDigits(toSum/10)
    else 0
  }

  def main(args: Array[String]) : Unit = {
    var biggestSoFar : BigInt = 0
    for( i <- 1 to 100){
      for( j <- 1 to 100){
        val x = sumDigits(BigInt(j).pow(i))
        if (x > biggestSoFar) {
          println("New biggest so far: " + x + " " + j + "^" + i)
          biggestSoFar = x
        }
      }
    }
  }
}
