
import Euler.NextPermutation

object Prob43 {
	def isDivisible(a: Long, b: Long) : Boolean = {
		((a%b) == 0) 
	}

	def makeNumber(a: Int, b: Array[Int]) : Long = {
		makeNumber(a,b,2)
	}  

	val primes  = Array(2,3,5,7,11,13,17)

	def makeNumber(a: Int, b: Array[Int], c: Int) : Long = {
		var total = 0L
			var power = 1L
			var idx = a+c
			for (i <- 0 to c){
				total += b(idx) * power
					idx -=1
					power *= 10
			}
		total
  }

	def run() : Unit = {
		println("start")
		var a = Array(1,2,3,4,5,6,7,8,9,0)
		var sum = 0L
		while(NextPermutation.next_permutation(a)){
			//println("Next permutation is: " + a.toString())
			var doAdd = true
				for ( i <- 1 to 7){
					if(doAdd && !isDivisible(makeNumber(i,a),primes(i-1))){	  
						doAdd = false
					}
				}
			if(doAdd){

				val num = makeNumber(0,a,9)
					println("Found: " + num + ". Array: " + a.toString())
					for (i <- 1 to 7){
						println("Using numbers: " + makeNumber(i,a))
					}	
				sum = sum + num
			}
		}
		println("End: " + sum)
	}
}
Prob43.run()
