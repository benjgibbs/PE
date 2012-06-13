
def isLeapYear(x: Int) : Boolean = {
  ( x % 4 == 0 && (x % 100 != 0 || x % 400 == 0))
}

def getDaysFor(month: Int, year: Int) : Int =  {
  val days =  Map(1->31, 3->31, 4->30, 5->31, 6->30, 7->31, 8->31, 9->30, 10->31, 11->30, 12->31)
  month match {
    case 2 => if(isLeapYear(year)) 29 else 28
    case _ => return days(month)
  }
}

var sundaysOnFirstCount = 0
//var day = 5 // 0 Monday, 6 Sunday
var day = 0 // 0 Monday, 6 Sunday
val numDaysOfWeek = 7
for (y <- 1900 to 2000){
//for (y <- 2000 to 2000){
  for(m <- 1 to 12){
    println("1/" + m + "/" + y + ": " + day) 
    if (day == 6 && y > 1900) {
      println("Sunday on first: " + m + "/" + y)
      sundaysOnFirstCount += 1
    }
    val days = getDaysFor(m,y) + day
    day = days % numDaysOfWeek
  }
}
println("Sundays on first: " + sundaysOnFirstCount)
