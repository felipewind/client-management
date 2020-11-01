package com.helesto.services;

import javax.enterprise.context.RequestScoped;

import com.google.gson.Gson;
import com.helesto.api.ResponseSelectClient;
import com.helesto.exceptions.BusinessError;
import com.helesto.exceptions.BusinessErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class ClientSelectService {

    private static final Logger LOG = LoggerFactory.getLogger(ClientUpdateService.class.getName());

    public ResponseSelectClient selectClientService(int clientId) throws BusinessErrorException {

        LOG.debug("SelectClientService");

        LOG.debug("Request: clientId: " + clientId);

        if (clientId == 0) {

            LOG.debug("BusinessError");

            throw new BusinessErrorException(new BusinessError(2, "Please inform the client ID"));
            
        }

        ResponseSelectClient response = new ResponseSelectClient();

        response.setName("John");
        response.setBirthDate("05.10.1980");
        response.setEmail("john-smith@emailtest.com");
        response.setPhoneNumber(5561984841234l);

        Gson gson = new Gson();
        String json = gson.toJson(response);
        LOG.debug("Response: " + json);

        return response;
    }

}