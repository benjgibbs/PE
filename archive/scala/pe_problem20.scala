
def fact(x:BigInt) : BigInt = {
  if(x == 1) return 1
  else return x * fact(x-1)
}

var sum = 0
fact(100).toString foreach((x: Char) => sum += Integer.parseInt("" + x))
println("Sum: " + sum)
