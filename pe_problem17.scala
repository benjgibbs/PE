
def andify(x: Int) : String = {
  val s = toWord(x)
  if (s.length > 0) return "and " + s 
  else return ""
}

def toWord(x: Int) : String = {
  if (x < 20) {
    x match {
      case 0 => return ""
      case 1 => return "one"
      case 2 => return "two"
      case 3 => return "three" 
      case 4 => return "four"
      case 5 => return "five" 
      case 6 => return "six" 
      case 7 => return "seven"
      case 8 => return "eight"
      case 9 => return "nine"
      case 10 => return "ten"
      case 11 => return "eleven"
      case 12 => return "twelve"
      case 13 => return "thirteen"
      case 14 => return "fourteen"
      case 15 => return "fifteen"
      case 16 => return "sixteen"
      case 17 => return "seventeen"
      case 18 => return "eighteen"
      case 19 => return "nineteen"
    }
  }
  else if (x < 30) return "twenty " + toWord(x - 20)
  else if (x < 40) return "thirty " + toWord(x - 30)
  else if (x < 50) return "forty " + toWord(x - 40)
  else if (x < 60) return "fifty " + toWord(x - 50)
  else if (x < 70) return "sixty " + toWord(x - 60)
  else if (x < 80) return "seventy " + toWord(x - 70)
  else if (x < 90) return "eighty " + toWord(x - 80)
  else if (x < 100) return "ninety " + toWord(x - 90)
  else if ( x < 1000) return toWord(x/100) + " hundred " + andify(x - (x/100 * 100)) 
  "one thousand"
}

def length(x: String) : Int = {
  x.replace(" ", "").length
}

var s = ""
for (x <- 1 to 1000) s+= toWord(x)
println("Total: " + length(s))

