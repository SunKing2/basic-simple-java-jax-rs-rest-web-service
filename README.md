# basic-simple-java-jax-rs-rest-web-service
##Simplest possible JAX-RS REST server

```
mvn jetty:run -DskipTests
```

This will build a WAR and run it with embedded Jetty

1. Show the one customer that was already there:
```
http://localhost:8080/services/customers
```

2. then perform a POST to create a customer
send it some fake xml data:
```
<junk></junk>
POST http://localhost:8080/services/customers
```

3. look at it:
```
http://localhost:8080/services/customers/2
```

4. then perform a PUT to update a customer
send it some fake xml data:
```
<junk></junk>
PUT http://localhost:8080/services/customers/1
```

5. now look at the customers again using:
```
http://localhost:8080/services/customers
```

Advanced:
I find I can run the junit tests (which use RestEasy) if I do the following in one terminal:
`mvn jetty:run -DskipTests`
and in the other terminal, run the tests,
`mvn test`
(I use eclipse to run them).

The intention of this is to get you running with a basic system.  The motivation is to create an environment that works so that you can do the examples in the JAX-RS Java book.
RESTful Java with JAX-RS 2.0 (Second Edition)

the end.
