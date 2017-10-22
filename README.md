Simplest possible JAX-RS REST server
========================
mvn clean install
mvn jetty:run

This will build a WAR and run it with embedded Jetty

http://localhost:8080/services/customers
http://localhost:8080/services/customers/1

then perform a POST to create a customer (it creates nothing, just increments counter)
send it some fake xml data:  <junk></junk>
POST http://localhost:8080/services/customers

then perform a PUT to update a customer (it updates nothing, just tells you it's ok)
send it some fake xml data:  <junk></junk>
PUT http://localhost:8080/services/customers/1

now look at the customers again using:
http://localhost:8080/services/customers
http://localhost:8080/services/customers/1

the end.
