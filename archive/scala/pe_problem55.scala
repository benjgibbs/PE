

object Problem55 {

  def reverse(k: BigInt) : BigInt = BigInt.apply(k.toString.reverse)
  def isPalindrome(k: BigInt) : Boolean = k == reverse(k)
  
  def main(args: Array[String])  = {
    var lNumbers : List[Int] = Nil
    for(i <- 100 to 10000){
      var cont = true
      var attempt = 0
      var num : BigInt = i
      while(cont){
        
        println("i="+i+",num="+num+",attempt="+attempt )
        
        if(attempt>0 && isPalindrome(num))
          cont = false
        else
          num = num + reverse(num)
        
        attempt = attempt +1

        if(attempt > 50) {
          cont = false
          lNumbers = i :: lNumbers
          println("A Lychrel Number: " + i )
        }
      }
    }
    println("LNumbers: " + lNumbers)
    println("LNumbers: " + lNumbers.size)
  }
}
