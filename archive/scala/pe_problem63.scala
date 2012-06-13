

def numDigits(i : BigInt) = i.toString().length()
def pow(i : BigInt, j : Int) : BigInt = if (j == 0) 1 else i * pow(i,j-1)

println(numDigits(BigInt(17805)))

var continue = true
var seqLen = 1
var pow = 1
var count = 0


while(continue){
   for (i <- 1 to 10 ) { 
     val num = pow(i,pow)
      if(numDigits(num) == pow){
           println("The number " + i + "^" + pow + "\tis " +
               num + " which has " + pow + " digits.")
           count += 1
       }
    }
    if( pow > 25 ) continue = false
    else pow += 1
}

println("That is " + count + " in total.")
