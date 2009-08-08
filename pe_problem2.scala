
//Problem 2
var x = 1
var y = 1
var total = 0
while(x < 4000000){
  if( x % 2 == 0){
    println(x)
    total += x
  }
  val t = x + y
  x = y
  y = t 
}
print(total)
