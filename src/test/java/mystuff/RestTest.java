package mystuff;

import static io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class RestTest {

	/*
	@Test public void
	lotto_resource_returns_200_with_expected_id_and_winners() {
	    
	    when().
	            get("/lotto/{id}", 5).
	    then().
	            statusCode(200).
	            body("lotto.lottoId", equalTo(5), 
	                 "lotto.winners.winnerId", containsOnly(23, 54));

	}
	*/
    @Test
    public void testCustomersReturns200() {
        given().when().get("http://localhost:8080/services/customers").then().statusCode(200);
    }
    @Test
    public void testCustomers1Returns200() {
        given().when().get("http://localhost:8080/services/customers/1").then().statusCode(200);
    }
    @Test
    public void testCustomersPostReturns201() {
        given().
        	contentType("application/xml").
        	formParam("anyxmlworks", "anyxmlworks").
        when().post("http://localhost:8080/services/customers").then().statusCode(201);
    }
    @Test
    public void testCustomers1PutReturns200() {
        given().
        	contentType("application/xml").
        	formParam("anyxmlworks", "anyxmlworks").
        when().put("http://localhost:8080/services/customers/1").then().statusCode(200);
    }
}
