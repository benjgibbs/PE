import utils.Utils


val primes = Utils.findPrimes(9999).filter( _ > 999)

def findPrimePermutations(x: Int)  = {
  for { 
    y <- Utils.allPermsOfDigits(x).toList.removeDuplicates 
    if (primes.contains(y)) } 
      yield y
}
def abs(x: Int) : Int = Math.abs(x)
def distances(x: List[Int]) = x.zip(x.tail).map((x) => x._2 - x._1)

val p2 = (for (p <- primes; if(findPrimePermutations(p).size > 3 )) yield findPrimePermutations(p).sort(_<_)).removeDuplicates

for(p3 <- p2) {
  val p4 = (for(j <- p3; k <-p3) yield (j,k,abs(j-k))).toList
  val p5 = p4.filter(x=>x._3!=0).sort( (x,y) => x._3 < y._3 ).remove( (x) => x._1 > x._2 )
  
  val p6 = (for(x <- p5) yield x._3).toList.removeDuplicates
  for(x <- p6) {
    if( p5.count( y => y._3 == x) > 2 ){
      for(k <- p5; if(k._3 == x))
        println(k) 
        
    }
  }
  //val p5 = (for( x <- p4) yield (x._2.size, x))
  //println(p5) 
}


println(p2.size)


//{
//  val perms = findPrimePermutations(p).toList.sort(_<_)
//  if(perms.size > 3 && 
//    (distances(perms).size > distances(perms).removeDuplicates.size+1)){
//    }
//}


//(for(i<-res0;j<-res0) yield (i,j,Math.abs(i-j))).toList.filter(x=>x._3!=0).sort((x,y)=>x._3<y._3) 
//
//(for(i<-res0;j<-res0; if(i!=j)) yield (i,j,Math.abs(i-j))).toList.sort((x,y)=>x._3<y._3).remove(x=>x._1>x._2)
//
//for(x <- res42) yield (x._2.size,x) 
//
//res66.toList.sort(_._1>_._1).head 
//res70: (Int, (Int, List[(Int, Int, Int)])) = (2,(4,List((5,9,4), (1,5,4)))) 


