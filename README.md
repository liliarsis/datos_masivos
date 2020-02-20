# Unit 1
# Introduction

Big data refers to the large, diverse sets of information that grow at ever-increasing rates.
It will be shown below, the practices in language Scala.
Scala is a general-purpose programming language providing support for functional programming and a strong static type system.
## Practica 1

1. Develop an algorithm in scala that calculates the radius of a circle
```
import scala.math.Pi
import scala.math.sqrt

//teniendo en cuenta la circunferencia
var circunferencia = 5 
(circunferencia)/(2*Pi) 

//teniendo en cuenta el area
var area = 8 
sqrt(area/Pi) 
```

2. Develop an algorithm in scala that tells me if a number is prime
```
def numPrime(n: Int): Boolean = {
    for(i <- 2.to(n/2)){
        if(n % i == 0) return false
    }
    true
}
numPrime(17) //true
numPrime(15) //false
```

3. Given the variable bird = "tweet", use string interpolation to print "Estoy ecribiendo un tweet"
```
val bird = "tweet"
printf(s"Estoy escribiendo un ", $bird)
```

4. Given the variable message = "Hola Luke yo soy tu padre!" use slice to extract the sequence "Luke"
```
val st = "Hola Luke yo soy tu padre!"
st slice  (5,9) //Extrae posicion 5 a 9
```

5. What is the difference in value and a variable in scala?
```
R= value (val) obtiene un dato que es inmutable osea, no puede ser modificado 
en cambio variable (var) obtiene un dato que puede cambiar 
siempre y cuando sea el mismo tipo.
```

6. Given the tuple ((2,4,5), (1,2,3), (3,116,23))) return the number 3.1416
```
val my_tup = ((2,4,5),(1,2,3),(3.1416,23))
my_tup._3
```

## Practica 2

1. Create a list called "lista" with the elements "rojo", "blanco", "negro"
2. Add 5 more items to "lista" "verde", "amarillo", "azul", "naranja", "perla"
3. Bring the "verde", "amarillo", "azul" items from "lista"
4. Create a number array in the 1-1000 range in 5-in-5 steps
5. What are the unique elements of the List lista (1,3,3,4,6,7,3,7) use conversion to sets
6. Create a mutable map called names that contains the following: "Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27"
6a. Print all map keys
6b. Add the following value to the map ("Miguel", 23)
