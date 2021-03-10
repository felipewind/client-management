package com.helesto.endpoint;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.helesto.dto.ClientDto;

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

        ClientDto request = new ClientDto();

        request.setName("Felipe");
        request.setBirthDate("03/25/1983");
        request.setEmail("felipe@teste.com");
        request.setPhoneNumber(987654);

        ClientDto response = 
            given()
            .contentType(ContentType.JSON)
            .body(request)
            .when()
            .post("/client")
            .then()
            .statusCode(200)
            .extract()
            .body()
            .as(ClientDto.class);

        assertTrue(response.getId()>0,"Client Id < 0");
        
    }

    @Test
    public void listClientSuccess() {
        
        LOG.info("listClientSuccess()");

        ClientDto[] response = 
            given()
            .when()
            .get("/client")
            .then()
            .statusCode(200)
            .extract()
            .body()
            .as(ClientDto[].class);

        assertTrue(response.length!=0,"Array is empty");
        
    }

    @Test
    public void updateClientSuccess() {
        
        LOG.info("updateClientSuccess()");

        ClientDto request = new ClientDto();

        request.setId(1);
        request.setName("Felipe");
        request.setBirthDate("03/25/1983");
        request.setEmail("felipe@teste.com");
        request.setPhoneNumber(987654);

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