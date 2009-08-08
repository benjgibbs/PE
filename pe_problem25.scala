
def sum(x: List[BigInt]): BigInt = {
  if(x.isEmpty) 0
  else x.head + sum(x.tail)
}

def maxForGreaterThanXDigits(x: BigInt) : BigInt = {
  if(x == 1) 9
  else BigInt(9)+(BigInt(10)*maxForGreaterThanXDigits(x-1))  
}

val max = maxForGreaterThanXDigits(999)
var Fx = BigInt(2)
var x = 2
var seq  = BigInt(1) :: BigInt(1) :: Nil 
println("Max: " + max)
while (Fx < max){
  x += 1
  Fx = sum(seq)
  seq = seq.tail ::: List(Fx)

}

println("First fib greater than " + max + " is " + Fx + " which is the " + x +" term.")
