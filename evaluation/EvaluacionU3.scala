// Importamos una sesion de scala
import org.apache.spark.sql.SparkSession

//importamos las lineas de codigo para minimizar errores
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

// se crea una instancia de la secion de spark
val spark = SparkSession.builder().getOrCreate()

// importamos la libreria k-mean
import org.apache.spark.ml.clustering.KMeans

//Cargamos nuestro dataset Wholesale customers data.csv
val data = spark.read.format("csv").option("inferSchema","true").option("header","true").csv("Wholesale customers data.csv")

//Ver las columnas que se necesitan para el modelo
data.printSchema

//Seleccione las siguientes columnas: Fres, Milk, Grocery, Frozen, Detergents_Paper,
//Delicassen y llamar a este conjunto feature_data
val feature_data = data.select($"Fresh", $"Milk", $"Grocery", $"Frozen", $"Detergents_Paper", $"Delicassen")

// Importar Vector Assembler y Vector
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.feature.StringIndexer

// Generamos un vector donde se almacenara las caracteristicas del dataset a evaluar mediante la columna features   
val assembler = new VectorAssembler().setInputCols(Array("Fresh","Milk","Grocery","Frozen","Detergents_Paper","Delicassen")).setOutputCol("features")

// Transformamos los datos utlizando nuestro dataset 
val featureSet = assembler.transform(feature_data)


// Creamos el modelo KMeans con K = 3
val kmeans = new KMeans().setK(3).setSeed(1L)
// Al aumentar el valor de K,  el valor de SSSME sera menor.
// val kmeans = new KMeans().setK(8).setSeed(1L)

// Agregar el modelo a featuerSet
val model = kmeans.fit(featureSet)

// Evalúe la agrupación mediante la computación dentro de la suma establecida de errores al cuadrado.
val WSSSE = model.computeCost(featureSet)

// Muestra el resultado
println(s"Within Set Sum of Squared Errors = ${WSSSE}"  )

// Mostramos los clusters
println("Cluster Centers: ")
model.clusterCenters.foreach(println)