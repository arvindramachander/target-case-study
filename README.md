myRetail is a rapidly growing company with HQ in Richmond, VA and over 200 stores across the east coast. myRetail wants to make its internal data available to any number of client devices, from myRetail.com to native mobile apps. 
The goal for this exercise is to create an end-to-end Proof-of-Concept for a products API, which will aggregate product data from multiple sources and return it as JSON to the caller. 

## SOLUTION:

About the application:
This RESTful service retrieves product and price details by ID and updates the product price information in the DB.

# Technology Stack:

Java 1.8 : http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
Spring Boot : https://start.spring.io/ https://spring.io/guides/gs/serving-web-content/
MongoDB : https://www.mongodb.com/what-is-mongodb
Gradle : https://gradle.org/install/
Mokito/Junit: http://site.mockito.org/
Postman: https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en

# How to run the application :

1) Download project from the following git repository : https://github.com/arvindramachander/target-case-study
2) Import the project as Gradle project in Eclipse.
3) Update the log file location in application.properties and DB name in application.yml files.
4) Run the following DML Statement to insert data into MongoDB :
> db.price.insert([{ "_id" : "13860428", "price" : "100", "currency" : "USD" } }])
5) Run the gradle tasks clean,build under build and bootRun under application to start the application.


# GET : Product is in DB and Title is returned from the external API.

![image](https://user-images.githubusercontent.com/23511695/37050541-baa2a9f0-2139-11e8-9e1b-1acf80d6d4e1.png)

# GET : Product is not in the DB.

![image](https://user-images.githubusercontent.com/23511695/37051045-17443f10-213b-11e8-8a54-e00ba7081a1a.png)

# GET : Product is in DB but title not returned from the external API

 MongoDB :
 
 ![image](https://user-images.githubusercontent.com/23511695/37051217-6ffca228-213b-11e8-8b21-458258fc9056.png)
 
 Response :
 
 ![image](https://user-images.githubusercontent.com/23511695/37051244-83de5d9a-213b-11e8-85bc-bddda197ea29.png)
 
# PUT : Product is in DB.

![image](https://user-images.githubusercontent.com/23511695/37051343-c7715ec2-213b-11e8-9bbc-9ef209c57fe0.png)

# PUT : ProductId in request does not match with body.

![image](https://user-images.githubusercontent.com/23511695/37051405-f43fadf0-213b-11e8-9539-ee4526b39a32.png)

# PUT : Product is not in DB.

![image](https://user-images.githubusercontent.com/23511695/37051438-0b7782c2-213c-11e8-9a57-4c3f4560f6f6.png)

 
