// importamos las librerias que vamos a usar
import org.apache.spark.mllib.classification.{SVMModel, SVMWithSGD}
import org.apache.spark.mllib.evaluation.BinaryClassificationMetrics
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.DateType
import org.apache.spark.sql.{SparkSession, SQLContext}
import org.apache.spark.ml.feature.VectorIndexer
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.Transformer
import org.apache.spark.ml.classification.LinearSVC
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.log4j._

// Con esto minimizamos errores
Logger.getLogger("org").setLevel(Level.ERROR)

// creamos una simple sesion de spark
val spark = SparkSession.builder().getOrCreate()

// cargamos nuetro data
val data = spark.read.option("header","true").option("inferSchema","true").option("delimiter",";").format("csv").load("bank-full.csv")


// convertimos datos a binario
val cbin1 = data.withColumn("y",when(col("y").equalTo("yes"),1).otherwise(col("y")))
val cbin2 = cbin1.withColumn("y",when(col("y").equalTo("no"),2).otherwise(col("y")))
val cnew = cbin2.withColumn("y",'y.cast("Int"))


// Generamos un vector donde se almacenara las caracteristicas del dataset a evaluar 
// y se aguardan mediante la columna features
val assembler = new VectorAssembler().setInputCols(Array("balance","day","duration","pdays","previous")).setOutputCol("features")
val featur= assembler.transform(cnew)


// cambiamos la columna "y" por etiquetas
val cambio = featur.withColumnRenamed("y", "label")
val feat = cambio.select("label","features")

// Realizamos el proceso de regresión logística
// Con 10 iteraciones
// Dividimos nuestro conjunto en 30% y 70%
val logistic = new LogisticRegression().setMaxIter(10).setRegParam(0.3).setElasticNetParam(0.7)

// Realizamos el ajuste del modelo
val logisticModel = logistic.fit(feat)

// Imprimimos los coeficientes y loas intersecciones del modelo
println(s"Coefficients: ${logisticModel.coefficients} Intercept: ${logisticModel.intercept}")
val logisticMult = new LogisticRegression().setMaxIter(10).setRegParam(0.3).setElasticNetParam(0.8).setFamily("multinomial")
val logisticMultModel = logisticMult.fit(feat)
println(s"Multinomial coefficients: ${logisticMultModel.coefficientMatrix}")
println(s"Multinomial intercepts: ${logisticMultModel.interceptVector}")
println(s"Test Error = ${(1.0 - accuracy)}")

// mostramos el tiempo de ejecucion
val time = System.nanoTime
val duration = (System.nanoTime - time) / 1e9d
 