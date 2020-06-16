// Assessment 1/Practica 1
//1. Desarrollar un algoritmo en scala que calcule el radio de un circulo
import scala.math.Pi
import scala.math.sqrt

//teniendo en cuenta la circunferencia
var circunferencia = 5 
(circunferencia)/(2*Pi) 
//teniendo en cuenta el area
var area = 8 
sqrt(area/Pi) 

//2. Desarrollar un algoritmo en scala que me diga si un numero es primo
def isPrime(num:Int): Boolean = {
    for(n <- Range(2, num)){
        if(num%n == 0){
            return false
        }
    }
    return true
}
isPrime(17) //true
isPrime(15) //false
                                                
//3. Dada la variable bird = "tweet", utiliza interpolacion de string para
//   imprimir "Estoy ecribiendo un tweet"
val bird = "tweet"
printf(s"Estoy escribiendo un ", $bird)

//4. Dada la variable mensaje = "Hola Luke yo soy tu padre!" utiliza slilce para extraer la
//   secuencia "Luke"
val st = "Hola Luke yo soy tu padre!"
st slice  (5,9) //Extrae posicion 5 a 9

//5. Cual es la diferencia en value y una variable en scala?
// R= value (val) obtiene un dato que es inmutable osea, no puede ser modificado 
// en cambio variable (var) obtiene un dato que puede cambiar 
// siempre y cuando sea el mismo tipo.

//6. Dada la tupla ((2,4,5),(1,2,3),(3.1416,23))) regresa el numero 3.1416 
val my_tup = ((2,4,5),(1,2,3),(3.1416,23))
my_tup._3