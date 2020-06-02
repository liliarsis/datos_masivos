import org.apache.spark.ml.regression.LinearRegression
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

//Start Spark Session
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()

// Load training data
val training = spark.read.format("libsvm").load("data/mllib/sample_linear_regression_data.txt")

// Create an object for linear regression model
val lr = new LinearRegression()

// Fit the model
val lrModel = lr.fit(output) //ajustar el output

// Print the coefficients and intercept for the linear regression
println(s"Coefficients: ${lrModel.coefficients} Intercept: ${lrModel.intercept}")

// Summarize the model on the training set print the output of some metrics
val trainingSummary = lrModel.summary
trainingSummary.residuals.show()
val RMSE = trainingSummary.rootMeanSquaredError
val MSE = scala.math.pow(RMSE, 2.0)
val R2 = trainingSummary.r2
