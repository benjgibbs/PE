
// x ^ y
def pow(x: BigInt, y: BigInt) : BigInt = {
  if(y == 1) return x
  else return x * pow(x, y-1)
}
val result = pow(2, 1000)
println( "\n2^1000: " + result)
var sum : BigInt = 0
for(x <- result.toString){
  sum = sum + Integer.parseInt(x + "")
}
println(sum)
