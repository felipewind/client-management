package com.helesto.endpoint;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.helesto.api.RequestCreateClient;
import com.helesto.api.RequestUpdateClient;
import com.helesto.api.ResponseCreateClient;
import com.helesto.api.ResponseListClient;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class ClientEndpointTest {

    private static final Logger LOG = LoggerFactory.getLogger(ClientEndpointTest.class.getName());

    @Test
    public void createClientSuccess() {
        
        LOG.info("createClientSuccess()");

        RequestCreateClient request = new RequestCreateClient();

        request.setName("Felipe");

        ResponseCreateClient response = 
            given()
            .contentType(ContentType.JSON)
            .body(request)
            .when()
            .post("/client")
            .then()
            .statusCode(200)
            .extract()
            .body()
            .as(ResponseCreateClient.class);

        assertTrue(response.getid()>0,"Client Id < 0");
        
    }

    @Test
    public void listClientSuccess() {
        
        LOG.info("listClientSuccess()");

        ResponseListClient response = 
            given()
            .when()
            .get("/client")
            .then()
            .statusCode(200)
            .extract()
            .body()
            .as(ResponseListClient.class);

        assertTrue(response.getListClient().size()!=0,"List is empty");
        
    }

    @Test
    public void updateClientSuccess() {
        
        LOG.info("updateClientSuccess()");

        RequestUpdateClient request = new RequestUpdateClient();

        request.setid(1);
        request.setName("Felipe");

        given()
            .contentType(ContentType.JSON)
            .body(request)
            .when()
            .put("/client")
            .then()
            .statusCode(200);
        
    }

    @Test
    public void deleteClientSuccess() {
        
        LOG.info("deleteClientSuccess()");

        given()
            .when()
            .get("/client?id=1")
            .then()
            .statusCode(200);
        
    }
 

}