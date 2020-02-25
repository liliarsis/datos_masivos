
Develop a function called diagonalDifference in a scrip with
the programming language scala. This must return an integer
that represents the difference of the absolute diagonal.


def diagonalDifference() = {
  val arr=((11,2,4),(4,5,6),(10,8,-12))
  var diagonal1 = (arr._1._1 + arr._2._2 + arr._3._3 )
  var diagonal2=(arr._1._3 + arr._2._2 + arr._3._1)
  var resultado= diagonal1-diagonal2
  var resl =math.abs(resultado)
  println(resl)
}

diagonalDifference()
