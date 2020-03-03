//1
import org.apache.spark.sql.SparkSession

val spar = SparkSession.builder().getOrCreate()

//2
val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")

//3
df.columns

//4
df.printSchema()

//5


df.select($"Date", $"Open", $"High", $"Low", $"Close").show()

//6
df.describe().show()

//7
val df2 = df.withColumn("HV Ratio", df("High")+df("Volume"))

//8
val dfmins = df2.groupBy("Date").max()

dfmins.select($"Date", $"max(Close)").show()

//9


//10

df.select(min("Volume"),max("Volume")).show()

//11
a-
val result = df2.filter($"Close" < 600).count()

b- (df.filter($"High" > 500).count() * 1.0/ df.count())*100

c-

d-

e-
val df3 = df.withColumn("Month", month(df("Date")))
val dfmes = df3.groupBy("Month").mean()
dfmes.select($"Month", $"avg(Close)").show();
