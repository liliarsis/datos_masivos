val arr=((11,2,4),(4,5,6),(10,8,-12))

def diagonalDifference(arr:(Int,Int,Int),(Int,Int,Int),(Int,Int,Int)) : Int = {
  var diagonal1 = (arr._1._1 + arr._2._2 + arr._3._3 )
  var diagonal2=(arr._1._3 + arr._2._2 + arr._3._1)
  var resultado= diagonal1-diagonal2
  var resl =math.abs(resultado)
  println(resl)
}
