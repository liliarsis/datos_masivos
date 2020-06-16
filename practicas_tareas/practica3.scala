//Algoritmos Fibonacci
//1. Recursive version
def adder(n:Int): Int = {

  if(n == 0){
    return (0)
  }
  else if(n==1){
    return (1)
  }
  else {
    return adder(n-1) + adder(n-2)
  }  
}

adder (9)

//2. Fibonacci Series using Dynamic Programming  
def f(n:Int):Int = {    
   val cache = scala.collection.mutable.Map.empty[Int,Int]
   def fInner(n:Int):Int = {  
     if(n == 0) 0
     else if (n == 1) 1
     else cache.getOrElseUpdate(n, fInner(n - 1) + fInner(n - 2))
    }    
 fInner(n)
}
 f(9) 
// Fibonacci tail recursive
def getFibonacci(index: Int): Int = {
  @annotation.tailrec
  def getTailRec(index: Int, prev: Int, current: Int): Int = {
    if (index <= 0) {
      current
    } else {
      getTailRec(index - 1, prev = prev + current, current = prev)
    }
  }

  getTailRec(index, prev = 1, current = 0)
}
getFibonacci(9)

// 4 Fibonacci array
    def fibonacci(i : Int) : Int = {      
        def h(last : Int, cur: Int, num : Int) : Int = {
            if ( num == 0) cur
            else h(cur, last + cur, num - 1)
        }

        if (i < 0) - 1
        else if (i == 0 || i == 1) 1
        else h(1,2,i - 2)
   }

   def main(args: Array[String]){
      (0 to 10).foreach( (x : Int) => print(fibonacci(x) + " "))
   }
fibonacci(9)   
// 5 Fibonacci
   def fib(n:Int):BigInt = {
   def fibs(n:Int):(BigInt,BigInt) = if (n == 1) (1,0) else {
     val (a,b) = fibs(n/2)
     val p = (2*b+a)*a
     val q = a*a + b*b
     if(n % 2 == 0) (p,q) else (p+q,p)
   }
   fibs(n)._1
}
fib(9)