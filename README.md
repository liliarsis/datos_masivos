# Unit 1
# Introduction

Big data refers to the large, diverse sets of information that grow at ever-increasing rates.
It will be shown below, the practices in language Scala.
Scala is a general-purpose programming language providing support for functional programming and a strong static type system.
# Content

- [Exercise 1](#exercise-1)
- [Exercise 2](#exercise-2)
- [Exercise 3 Fibonacci](#exercise-3)
- [Evaluation 1](#evaluation-1)
- [Exercise 4](#exercise-4)
- [Exercise 5](#exercise-5)
- [What is Pearson Correlation](#investigation-1)
- [What is Variance?](#investigation-2)
- [Evaluation 2](#evaluation-2)
- [Collaborators](#collaborators)

## Exercise 1

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

## Exercise 2

1. Create a list called "lista" with the elements "rojo", "blanco", "negro"
```
var lista: List[String] = List("rojo", "blanco", "negro")
```

2. Add 5 more items to "lista" "verde", "amarillo", "azul", "naranja", "perla"
```
val lista2 ="verde"::"amarillo"::"azul"::"naranja"::"perla" ::lista
```

3. Bring the "verde", "amarillo", "azul" items from "lista"

```
lista2.slice(0,3)
```

4. Create a number array in the 1-1000 range in 5-in-5 steps
```
val pasos = List.range(1, 1000, 5)
```
5. What are the unique elements of the List lista (1,3,3,4,6,7,3,7) use conversion to sets

```
val lista=Set(1,3,3,4,6,7,3,7)
```

6. Create a mutable map called names that contains the following: "Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27"
6a. Print all map keys
6b. Add the following value to the map ("Miguel", 23)

```
val nombres = Map(("jose", 20), ("Luis", 24), ("Ana", 23),("Susana",27))
nombres.keys
nombres + ("Miguel" ->23)
```

## Exercise 3

create the Fibonacci algorithm in 5 different ways

1. Recursive version

```
def fib(n:Int):Int = {
  if (n<2){
    return (n)
  }
  else {
    return fib(n-1)+fib(n-2)
  }
}

fib(5)
```
2. Fibonacci Series using Dynamic Programming 
```
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
 ```
 
3. Fibonacci tail recursive
```
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
```

4. Fibonacci array
```
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
```
5. Fibonacci
```
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
```
## Evaluation 1
```
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
```

## Investigation 1
### What is Pearson correlation?
Correlation coefficients are used in statistics to measure how strong a relationship is between two variables. There are several types of correlation coefficient: Pearson’s correlation (also called Pearson’s R) is a correlation coefficient commonly used in linear regression. The full name is the Pearson Product Moment Correlation (PPMC). It shows the linear relationship between two sets of data. 
### Real life example
Pearson correlation is used in thousands of real life situations. For example, scientists in China wanted to know if there was a relationship between how weedy rice populations are different genetically. The goal was to find out the evolutionary potential of the rice. Pearson’s correlation between the two groups was analyzed. It showed a positive Pearson Product Moment correlation of between 0.783 and 0.895 for weedy rice populations. This figure is quite high, which suggested a fairly strong relationship.

## Exercise 4
### 20 Scala functions

```
import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")

df.printSchema()

df.show()

df.describe ("High").show //1 Describe los valores estadisticos de la columna seleccionada

df.select ("High","Close").show //2 Despliega los valores relacionados de las columnas consultadas.

df.select ("Open","Low").filter("Close < 480").show //3 Despliega la colummnas relacionadas y seleccionadas y pone un filtro para solo desplegar las que sean menor a 480

df.groupBy ("Open").show //4 Agrupa la columna

df.first //5 Retorna la primera columna del dataframe

df.columns //6 Retorna las columnas de dataframe

val df2 = df.withColumn("HV Ratio", df("High")+df("Volume")) //7 Agrega una columna que deriva de la columna high y Volume

df.select(min("Volume")).show() //8 Optiene el min de la columna volume 

df.select(max("Volume")).show() //9 Obtiene el max de la columna volume

val df2 = df.withColumn("Year", year(df("Date"))) //10 Crea la columa año apartir de la columna date

val df3 = df.withColumn("Month", month(df("Date"))) //11 Crea la columna mes apartir de la columna date

val df3 = df.withColumn("Day", dayofmonth(df("Date"))) //12 crea la columna dia apartir de la columna mes y date

val df3 = df.withColumn("Day", dayofyear(df("Date"))) //13 Crea la columna dia apartir de la columna año
 
df.select(corr($"High", $"Volume")).show() //14 retorna la correlacion entre la columna High y Volume

df.select($"High").take(1) //15 Toma 1 columna de de la columna
 
df.select("High").repartition().show() //16 Reparticia la columna seleccionada

df.sort($"High".asc).show() //17 Sortea la columa High

df.select(avg("High")).show() //18 Muestra el promedio de la columna high 

df.filter($"Close" < 480 && $"High" < 480).collectAsList() //19 crea una lista apartir de una coleccion. 

df.select(last_day(df("Date"))).show() //20 retorna el ultimo dia de la columna date 
```
## Exercise 5
### Apply scala functions to Diamonds.CSV
```
import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("P2-Mispriced-Diamonds.csv")

df.select(max("Price")).show() //Muestra el valor maximo de la columna Price

df.select(min("Price")).show() // Muestra el valor minimo de la columna Price

df.select(variance("Price")).show() //Muestra la varianza de la columna Price

df.select(stddev("Price")).show() // Muestra la desviacion estandar de la columna Price

df.select(first("Price")).show() // Muestra la primer fila

df.select(last("Price")).show() // Muestra la ultima fila

df.select(mean("Price")).show() //Muestra la media de la columa

df.select(length("Price")).show() //Muestra el tamano de la columna

df.select(avg("Price")).show() //Muestra el promedio de la columna

df.groupBy("Company").count().show() //Agrupa la columna

df.select(sum("Sales")).show() //Muestra la sumatoria de Sales

df.select(approx_count_distinct("Price")).show() //Muestra un recuento aproximado de elementos
```

## Investigation 2
### What is Variance?
Variance (σ2) in statistics is a measurement of the spread between numbers in a data set. That is, it measures how far each number in the set is from the mean and therefore from every other number in the set.
Variance is calculated by taking the differences between each number in the data set and the mean, then squaring the differences to make them positive, and finally dividing the sum of the squares by the number of values in the data set.

## Evaluation 2
```
//1 Se inicia sesion de spark 
import org.apache.spark.sql.SparkSession

val spar = SparkSession.builder().getOrCreate()

//2 Carga el archivo Netflix, se crea el dataframe
val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")

//3 Muestra columnas
df.columns

//4 Muestra el esquema
df.printSchema()

//5 Muestra las primeras 5 columnas
df.select("Date", "Open", "High", "Low", "Close").show()

//6 Funcion que describe el dataframe
df.describe().show()

//7 Crea un nuevo dataframe con una columna nueva llamada HV Ratio, 
// a partir de las columnas High y Volume
val df2 = df.withColumn("HV Ratio", df("High")/df("Volume"))

//8 Dia con el pico mas alto de la columna Close
val dfmax = df.orderBy($"Close".desc)// primero ordena la columna Close

dfmax.select("Date", "Close").first()//muestra la primera fila

//9 Significado de la columna close 
//R= La columna Close tiene los datos numericos del cierre de ventas de Netflix
//Muestra la media de la columna Close: df.select(mean("Close")).show()

//10 Maximo y minimo de la columna Volume
df.select(min("Volume"),max("Volume")).show()

//11 Sintaxis Scala/Spark
//a. Dias de la columna Close menor a 600
df.filter($"Close" < 600).count()

//b. Porcentaje del tiempo de la columna High mayor a 500
df.filter($"High" > 500).count() * 1.0/ df.count()*100

//c. Correlacion Pearson entre columna High y Volume
df.select(corr("High", "Volume")).show()

//d. Maximo de la columna High por ano
val df3 = df.withColumn("Year", year(df("Date")))
val dfano = df3.groupBy("Year").max()
dfano.select("Year", "max(High)").show()

//e. Promedio de la columna Close para cada mes
val df4 = df.withColumn("Month", month(df("Date")))
val dfmes = df4.groupBy("Month").mean()
dfmes.select($"Month", $"avg(Close)").show();
```

## References
- Correlation Coefficient: Simple Definition, Formula, Easy Calculation Steps
[https://www.statisticshowto.datasciencecentral.com/probability-and-statistics/correlation-coefficient-formula/](https://www.statisticshowto.datasciencecentral.com/probability-and-statistics/correlation-coefficient-formula/)
- Using the Variance Equation. Adam Hayes - [https://www.investopedia.com/terms/v/variance.asp](https://www.investopedia.com/terms/v/variance.asp)

## Collaborators
* **Manuel Orozco** - [Github](https://github.com/manuelorozcotoro)
* **Lilia Rosales** - [Github](https://github.com/liliarsis)
