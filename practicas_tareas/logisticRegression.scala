import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.sql.SparkSession
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.ml.Pipeline
import org.apache.spark.mllib.evaluation.MulticlassMetrics

//Start Spark session
val spark = SparkSession.builder().getOrCreate()

// Load training data
val data  = spark.read.option("header","true").option("inferSchema", "true").format("csv").load("advertising.csv")


val timedata = data.withColumn("Hour",hour(data("Timestamp")))

val logregdata = timedata.select(data("Clicked on Ad").as("label"), $"Daily Time Spent on Site", $"Age", $"Area Income", $"Daily Internet Usage", $"Hour", $"Male")

val assembler = (new VectorAssembler()
                  .setInputCols(Array("Daily Time Spent on Site", "Age","Area Income","Daily Internet Usage","Hour","Male"))
                  .setOutputCol("features"))

val Array(training, test) = logregdata.randomSplit(Array(0.7, 0.3), seed = 12345)

// Creates a logistic regression object
val lr = new LogisticRegression()
val pipeline = new Pipeline().setStages(Array(assembler, lr))

// Fit the model
val model = pipeline.fit(training)
val results = model.transform(test)

//Calculate predictions
val predictionAndLabels = results.select($"prediction",$"label").as[(Double, Double)].rdd
val metrics = new MulticlassMetrics(predictionAndLabels)

//Print confusion matrix
println("Confusion matrix:")
println(metrics.confusionMatrix)
metrics.accuracy
