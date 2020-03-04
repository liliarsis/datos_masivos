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
