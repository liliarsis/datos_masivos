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
