object Problem65 {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(175); 
	 /*
		O2 = 1+1/(1+O1)
		     1+1/(1+n/d)
		     1+d/(d+n)
		     (n+2*d)/(n+d)
	 */
 
  def nextRoot2(prev:(Int,Int)) = (prev._1+2*prev._2,prev._1+prev._2);System.out.println("""nextRoot2: (prev: (Int, Int))(Int, Int)""");$skip(116); 
  
  def iter(depth:Int) : (Int,Int) = depth match {
    case 1 => (1,1)
    case _ => nextRoot2(iter(depth-1))
  };System.out.println("""iter: (depth: Int)(Int, Int)""");$skip(114); val res$0 = 
  //1, 3/2, 7/5, 17/12, 41/29, 99/70, 239/169, 577/408, 1393/985, 3363/2378
  for(i <- 1 to 10)
    yield iter(i);System.out.println("""res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$0))}
  
  //2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536
  /*
	  O1 = 2
	  O2 = 2+1/1 = 3
		O3 = 2+1/(1+1/2) = 8/3
		O4 = 2+1/(1+1/(2+1/1)) = 11/4
		05 = 2+1/(1+1/(2+1/(1+1/1))) = 19/7
		06 = 2+1/(1+1/(2+1/(1+1/(1+1/2)))) = ...
		
	*/
	
  
}