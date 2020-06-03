//Importamos las liberrias que utilizaremos en el proyecto 

import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import spark.implicits._
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.feature.StringIndexer

//Cargamos nuestro datos desde el archivo a un dataset
val data = spark.read.format("csv").option("inferSchema","true").option("header","true").csv("iris.csv")

//Nos muetra las columnas del datset
data.columns

//hacemos un printschema para ver la estructura de la data
data.printSchema()

//Muestra las columnas
data.show()

//Funcion que describe el data 
data.describe().show()

// Generamos un vector donde se almacenara las caracteristicas del dataset a evaluar 
// y se aguardan mediante la columna features   
val assembler = new VectorAssembler().setInputCols(Array("sepal_length","sepal_width","petal_length","petal_width")).setOutputCol("features")

// Transformamos los datos utlizando nuestro dataset 
val featureSet = assembler.transform(data)


//Transformamos los valores categoricos a datos numeros para poder procesarlo 
val labelIndexer = new StringIndexer().setInputCol("species").setOutputCol("label")
val dataindex = labelIndexer.fit(featureSet).transform(featureSet)


// preparamos nuestro datos  de entrenamiento y datos de prueba
// el conjunto de prueba: entrenamiento => 60%, prueba => 40% y semilla => 1234L
val splits = dataindex.randomSplit(Array(0.6, 0.4), seed = 1234L)
val train = splits(0)
val test = splits(1)

//Especificamos las capas de nuestra red neuronal 
/*specifique las capas para la red neuronal
    Especifique las capas para la red neuronal de la siguiente manera: 
    capa de entrada => tamaño 4(características), 
    dos capas intermedias (es decir, capa oculta) 
    de tamaño 5 y 4 y salida => tamaño 3 (clases). */
val layers = Array[Int](4, 5, 4, 3)


// creamos el entrenador MultilayerPerceptronClassifier y establezca sus parámetros
val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setBlockSize(128).setSeed(1234L).setMaxIter(100)

 /* Entrene el modelo de clasificación de perceptrón multicapa utilizando el estimador
Entrene el modelo de clasificación de perceptrón multicapa utilizando el estimador anterior (es decir, entrenador)  */     
val model = trainer.fit(train)

//  Creamos nuestro modelo de computacion para determinar nuestro valor de predccion mas acertado 
val result = model.transform(test)
val predictionAndLabels = result.select("prediction", "label")

// evalúe el modelo para el rendimiento de predicción
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")

//Imprimimos el resultado de la predicciòn. 
println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")