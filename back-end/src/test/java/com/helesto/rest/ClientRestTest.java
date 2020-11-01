package com.helesto.rest;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.helesto.api.RequestInsertClient;
import com.helesto.api.ResponseInsertClient;
import com.helesto.api.ResponseSelectClient;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class ClientRestTest {

    private static final Logger LOG = LoggerFactory.getLogger(ClientRestTest.class.getName());

    @Test
    public void insertClientSuccess() {
        
        LOG.info("insertClientSuccess()");

        RequestInsertClient request = new RequestInsertClient();

        request.setName("Felipe");

        ResponseInsertClient response = 
            given()
            .contentType(ContentType.JSON)
            .body(request)
            .when()
            .post("/client")
            .then()
            .statusCode(200)
            .extract()
            .body()
            .as(ResponseInsertClient.class);

        assertTrue(response.getClientId()>0,"Client Id < 0");
        
    }

    @Test
    public void selectClientSuccess() {
        
        LOG.info("selectClientSuccess()");

        ResponseSelectClient response = 
            given()
            .when()
            .delete("/client/1")
            .then()
            .statusCode(200)
            .extract()
            .body()
            .as(ResponseSelectClient.class);

        assertTrue(response.getName()!=null,"Client Name is null");
        
    }


}