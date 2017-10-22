# basic-simple-java-jax-rs-rest-web-service
##Simplest possible JAX-RS REST server

mvn clean install
mvn jetty:run

This will build a WAR and run it with embedded Jetty

Show the one customer that was already there:
http://localhost:8080/services/customers

then perform a POST to create a customer
send it some fake xml data:  <junk></junk>
POST http://localhost:8080/services/customers

look at it:
http://localhost:8080/services/customers/2

then perform a PUT to update a customer
send it some fake xml data:  <junk></junk>
PUT http://localhost:8080/services/customers/1

now look at the customers again using:
http://localhost:8080/services/customers

Advanced:
I find I can run the junit tests (which use RestEasy) if I do the following in one terminal:
mvn jetty:run
and in the other terminal, run the tests (I use eclipse to run them).

The intention of this is to get you running with a basic system.  The motivation is to create an environment that works so that you can do the examples in the JAX-RS Java book.
RESTful Java with JAX-RS 2.0 (Second Edition)

the end.
