
/* Develop a function called diagonalDifference in a scrip with
the programming language scala. This must return an integer
that represents the difference of the absolute diagonal.*/


//diagonalDifference function
def diagonalDifference() = {
  val arr=((11,2,4),(4,5,6),(10,8,-12))//creates array
  var diagonal1 = (arr._1._1 + arr._2._2 + arr._3._3 )//creates variable with 1,2,3 position
  var diagonal2=(arr._1._3 + arr._2._2 + arr._3._1)//creates variable with 3,2,1 position
  var resultado= diagonal1-diagonal2//substraction
  var resl =math.abs(resultado)//absolut result
  println(resl)//print result
}

diagonalDifference()//calls function
