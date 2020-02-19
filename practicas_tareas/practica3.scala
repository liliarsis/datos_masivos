//Algoritmos Fibonacci
//Recursive version
def adder(n:Int): Int = {

  if(n==0){
    return (0)
  }
  else if(n==1){
    return (1)
  }
  else {
    return adder(n-1) + adder(n-2)
  }  
}

adder (10)