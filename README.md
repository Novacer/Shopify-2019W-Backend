# Shopify-2019W-Backend
For the 2019 Winter Shopify Dev Internship Challenge


Deployed on Google Kubernetes Engine at http://35.237.1.196 with a Docker image.

Comes with swagger docs for easy interactivity.

The stack is made using Java Spring as the web framework, h2 as the JDBC, and Swagger as the "frontend" (just kidding).

On application startup it will create an in memory database and insert some mock data just for the demonstration.
You can see that [here.](https://github.com/Novacer/Shopify-2019W-Backend/blob/master/src/main/resources/data.sql)

I chose this Stack because the challenge description was a very relational problem (A has many B's etc...). Hence it made sense to use a relational database. The advantage of a relational database lies in the fact that you can have foreign keys into other tables, which permits you to get everything related to a Shop even if the data is in different tables. Furthermore, I chose to use the Java Spring Framework due to Java's Object Oriented nature, which allowed me to use ORM to abstract away a lot of the database stuff and just focus on making the APIs. The Spring Framework also makes it easy to do testing and security stuff should I choose to expand down that route more. All in all it's pretty OP.
