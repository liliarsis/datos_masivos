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
