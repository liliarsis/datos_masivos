**PROJECT FINAL**

**INDEX**

*Task*
* [T1.-Task 1, INTRODUCTION](#T1)
* [T2.-Task 2, THEORETICAL FRAMEWORK](#T2)
* [T3.-Task 3, IMPLEMENTATION](#T3)
* [T4.-Task 4, RESULTS](#T4)
* [T5.-Task 5, CONCLUSION](#T5)
* [T6.-Task 6, REFERENCES](#T6)


<a name="T1"></a>
# INTRODUCTION

Machine learning is a method of data analysis that automates the construction of analytical models. It is a branch of artificial intelligence based on the idea that systems can learn from data, identify patterns, and make decisions with minimal human intervention.

Since the creation of these methods, we have looked for ways to make better use of them and over time and the evolution of technologies, today machine learning algorithms are increasingly relevant to this complex development.

Most industries that deal with large amounts of data have recognized the value of machine learning technology. By gaining insights from this data - often in real time - organizations can work more efficiently or gain an advantage over their competitors.

<a name="T2"></a>
# THEORETICAL FRAMEWORK

## Machine Learning algorithm groups:

1.Supervised learning
In supervised learning, the machine is taught by example. In this way, the operator provides the machine learning algorithm with a known data set that includes the desired inputs and outputs, and the algorithm must find a method to determine how to get to those inputs and outputs.

While the operator knows the correct answers to the problem, the algorithm identifies patterns in the data, learns from the observations, and makes predictions. The algorithm makes predictions and is operator corrected, and this process continues until the algorithm reaches a high level of precision and performance.

2.Unsupervised learning
Here, the machine learning algorithm studies the data to identify patterns. There is no response key or human operator to provide instruction. Instead, the machine determines correlations and relationships by analyzing the available data.

In an unsupervised learning process, the machine learning algorithm is allowed to interpret large data sets and direct that data accordingly. Thus, the algorithm tries to organize that data in some way to describe its structure. This could mean the need to group the data into groups or organize it in a way that makes it look more organized.

3.Reinforcement learning
Reinforcement learning focuses on regulated learning processes, where machine learning algorithms are provided with a set of actions, parameters, and end values.

By defining the rules, the machine learning algorithm tries to explore different options and possibilities, monitoring and evaluating each result to determine which one is optimal.

Consequently, this system teaches the machine through the trial and error process. Learn from past experiences and begin to adapt your approach in response to the situation to achieve the best possible result.

## Machine Learning algorithms for classification (SVM)

A support vector machine (SVM) is a supervised learning algorithm that can be used for binary classification or regression. Support vector machines are very popular in applications such as natural language processing, speech, image recognition, and machine vision.

A support vector machine builds an optimal hyperplane in the form of a decision surface, so that the margin of separation between the two classes in the data is maximized. Support vectors refer to a small subset of the training observations that are used as support for the optimal location of the decision surface.

Support vector machines belong to a class of Machine Learning algorithms called kernel methods and are also known as kernel machines.

The training of a support vector machine consists of two phases:

1-Transform the predictors (input data) into a space with highly dimensional characteristics. In this phase it is enough to specify the kernel; the data is never explicitly transformed into the feature space. This process is commonly known as the kernel trick.
2-Solve a quadratic optimization problem that fits an optimal hyperplane to classify the transformed characteristics into two classes. The number of transformed features is determined by the number of support vectors.


![Grafica1](https://raw.githubusercontent.com/liliarsis/datos_masivos/unit4/imagenes/figura1.PNG)

## Decision Three

A decision tree is a simple representation to classify examples. It is a supervised machine learning where the data is divided continuously according to a certain parameter.

Decision tree consists of:
1- Nodes: test the value of a certain attribute.
2- Borders / branch: corresponds to the result of a test and connects to the next node or leaf.
3- Leaf nodes: terminal nodes that predict the result (represents class labels or class distribution).

To understand the concept of Decision Tree, consider the example in Fig. 2. Let's say you want to predict whether a person is fit or not, given their information such as age, eating habits, physical activity, etc. Decision nodes are questions like 'How old are you?', 'Do you exercise?', 'Do you eat a lot of pizzas? And the sheets represent results such as 'pass' or 'fail'.

![Grafica1](https://raw.githubusercontent.com/liliarsis/datos_masivos/unit4/imagenes/figura2.PNG)

There are two main types of decision trees:
1.Classification trees (Yes / No types) Fig. 3:
What we have seen above is an example of a classification tree, where the result was a variable such as "pass" or "fail". Here the decision variable is categorical / discrete.
Such a tree is built through a process known as a binary recursive partition. This is an iterative process of dividing the data into partitions and then dividing it into each of the branches.

![Grafica1](https://raw.githubusercontent.com/liliarsis/datos_masivos/unit4/imagenes/figura3.PNG)

2.Regression trees (continuous data types):
Decision trees where the target variable can take continuous values ​​(typically real numbers) are called regression trees. (for example, the price of a house or the length of a patient's stay in a hospital)

![Grafica1](https://raw.githubusercontent.com/liliarsis/datos_masivos/unit4/imagenes/figura4.PNG)

## Logistic Regression

Logistic Regression or Logistic Regression is a classification algorithm that is used to predict the probability of a categorical dependent variable. In logistic regression, the dependent variable is a binary variable that contains data encoded as 1 - 0, yes - no, open - closed, etc.

This binary logistic model is used to estimate the probability of a binary response based on one or more independent or predictive variables. Lets say that the presence of a risk factor increases the probability of a result given a specific percentage.

Like all regression analyzes, logistic regression is predictive analysis. It is used to describe data and explain the relationship between a dependent binary variable and one or more independent nominal, ordinal, interval, or ratio level variables.

Some of the examples of classification problems are spam or not, online transactions fraud or non-fraud, malignant or benign tumor Fig. 5. The logistic regression transforms your output using the logistic sigmoid function to return a probability value.

![Grafica1](https://raw.githubusercontent.com/liliarsis/datos_masivos/unit4/imagenes/figura5.PNG)

## Multilayer perceptron

MLPs are forward-facing networks with one or more node layers between the input nodes and the output nodes (Hidden). Each neuron is a perceptron type. Each layer is fully connected to the next layer in the network.

Perceptron Fig. 6: Artificial neuron or basic inference unit in the form of a linear discriminator, from which an algorithm is developed capable of generating a criterion to select a sub-group from a larger group of components.

![Grafica1](https://raw.githubusercontent.com/liliarsis/datos_masivos/unit4/imagenes/figura6.PNG)

LAYERS
The layers can be classified into three types Fig. 7:

1-Input layer: Made up of those neurons that introduce the input patterns into the network. No processing occurs in these neurons.
2-Hidden layers: Formed by those neurons whose inputs come from previous layers and whose outputs go to neurons from later layers.
3-Output layer: Neurons whose output values ​​correspond to the outputs of the entire network.

![Grafica1](https://raw.githubusercontent.com/liliarsis/datos_masivos/unit4/imagenes/figura7.PNG) 

CHARACTERISTICS:
-An MLP consists of at least three layers of nodes.
-MLP uses a supervised learning technique called back propagation for training.
-You can distinguish data that is not linearly separable.
-It is one of the architectures most used to solve real problems.
-It tends to work best with deeper architectures and larger networks.

<a name="T3"></a>
# IMPLEMENTATION

For the comparison of these algorithms we use apache spark, with its extension to work with the scala language.
Scala is a modern multi-paradigm programming language designed to express common programming patterns in a concise, elegant, and secure way of writing. Easily integrate functional and object-oriented language features. Thanks to the implementation of this language, we can program an algorithm in a simpler way with a performance that exceeds other languages, because we work through a base with Spark.

Spark version: 2.4.4

Scala version: 2.11.12

<a name="T4"></a>
# RESULTS

To carry out this project, the same file was used for the implementation of the 4 different Machine Learning algorithms, of which the iteration of each of these was carried out ten times.
The following tables show the results as well as the average of each of them.

![Grafica1](https://raw.githubusercontent.com/liliarsis/datos_masivos/unit4/imagenes/figura8.PNG)

<a name="T5"></a>
# CONCLUSION

After analyzing the results tables we can conclude that:
- The average feasibility of the Logistic Regression algorithm is on average 89% which is the best, followed by the Decision Tree algorithm which is very close to it with 88%.
- Regarding the margin of error we can also see that the Logistic Regression algorithm is smaller, therefore it is more favorable.
- Regarding the execution time, we can see that Decision Tree performed the iterations in a shorter time.

In this way we can assume that the most favorable algorithm was the Logistic Regression algorithm.

**link of video**

<a name="T6"></a>
# REFERENCES

[1] SAS. (2019). Aprendizaje Automático. Junio 13, 2020, de SAS Institute Inc Sitio web: https://www.sas.com/es_mx/insights/analytics/machine-learning.html#machine-learning-importance 
[2] Redacción APD. (2019). ¿Cuáles son los tipos de algoritmos del machine learning?. Junio 13, 2020, de APD Sitio web: https://www.apd.es/algoritmos-del-machine-learning/#:~:text=Los%20tres%20 grupos%20de%20algoritmos,no%20supervisado%20y%20por%20refuerzo. 
[3]MathWorks. (2019). Máquina de vectores de soporte (SVM). Junio 13, 2020, de The MathWorks Inc Sitio web: https://es.mathworks.com/discovery/support-vector-machine.html 
[4]Afroz Chakure. (2019). Decision Tree Classification. Junio 13, 2020, de Towards data science Sitio web: https://towardsdatascience.com/decision-tree-classification-de64fc4d5aac 
[5]Gonzalez L.. (2018). Aprendizaje Supervisado: Logistic Regression. Junio 13, 2020, de ligdigonzalez.com Sitio web: https://ligdigonzalez.com/aprendizaje-supervisado-logistic-regression/#:~:text=La%20regresi%C3%B3n%20log%C3%ADstica%20o%20Logistic,de%20una%20variable%20dependiente%20categ%C3%B3rica.&text=Permite%20decir%20que%20la%20presencia,resultado%20dado%20un%20porcentaje%20espec%C3%ADfico. 
[6]Ayush P.. (2019). Introduction to Logistic Regression. Junio 13, 2020, de towards data science Sitio web: https://towardsdatascience.com/introduction-to-logistic-regression-66248243c148 
[7] Guillen, J. (2015, julio 19). Perceptrón simple y multicapa. Recuperado 1 de mayo de 2020, de https://es.slideshare.net/Jeffo92/perceptrn-simple-y-multicapa 

