package com.helesto.rest;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.helesto.schema.RequestInsertClient;
import com.helesto.schema.ResponseInsertClient;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class InsertClientTestTest {

    private static final Logger LOG = LoggerFactory.getLogger(InsertClientTestTest.class.getName());

    @Test
    public void testInsertClientSuccess() {
        
        LOG.info("testInsertClientSuccess()");

        RequestInsertClient request = new RequestInsertClient();

        request.setName("Felipe");

        ResponseInsertClient response = 
            given()
            .contentType(ContentType.JSON)
            .body(request)
            .when()
            .post("/client/insert")
            .then()
            .statusCode(200)
            .extract()
            .body()
            .as(ResponseInsertClient.class);

        assertTrue(response.getClientId()>0,"Client Id < 0");
        
    }

    // @Test
    // public void testInsertClientBusinessError() {
        
    //     LOG.info("testInsertClientBusinessError()");

    //     RequestInsertClient request = new RequestInsertClient();

    //     request.setName("");

    //     ErrorResponse response = 
    //         given()
    //         .contentType(ContentType.JSON)
    //         .body(request)
    //         .when()
    //         .post("/client/insert")
    //         .then()
    //         .statusCode(422)
    //         .extract()
    //         .body()
    //         .as(ErrorResponse.class);

    //     assertTrue(response.getErrorCode()==2,"name wasn't informed");
        
    // }


    // @Test
    // public void testInsertClientSystemError() {
        
    //     LOG.info("testInsertClientSystemError()");

    //     ErrorResponse response = 
    //         given()
    //         .contentType(ContentType.JSON)
    //         .body("error")
    //         .when()
    //         .post("/client/insert")
    //         .then()
    //         .statusCode(500)
    //         .extract()
    //         .body()
    //         .as(ErrorResponse.class);

    //     assertTrue(response.getErrorCode()==1,"System error");
        
    // }

}