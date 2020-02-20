# Unit 1
# Introduction

Big data refers to the large, diverse sets of information that grow at ever-increasing rates.
It will be shown below, the practices in language Scala.
Scala is a general-purpose programming language providing support for functional programming and a strong static type system.
## Practica 1

1. Desarrollar un algoritmo en scala que calcule el radio de un circulo
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

 1. Crea una lista llamad "lista" con los elementos "rojo", "blanco", "negro"
 2. Añadir 5 elementos mas a "lista" "verde" ,"amarillo", "azul", "naranja", "perla"
 3. Traer los elementos de "lista" "verde", "amarillo", "azul"
 4. Crea un arreglo de numero en rango del 1-1000 en pasos de 5 en 5
 5. Cuales son los elementos unicos de la lista Lista(1,3,3,4,6,7,3,7) utilice conversion a conjuntos
 6. Crea una mapa mutable llamado nombres que contenga lo siguiente: "Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27"
 6a. Imprime todas la llaves del mapa
 6b. Agrega el siguiente valor al mapa("Miguel", 23)
