package com.helesto.services;

import javax.enterprise.context.RequestScoped;

import com.google.gson.Gson;
import com.helesto.api.ResponseReadClient;
import com.helesto.exceptions.BusinessError;
import com.helesto.exceptions.BusinessErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class ClientReadService {

    private static final Logger LOG = LoggerFactory.getLogger(ClientUpdateService.class.getName());

    public ResponseReadClient readClientService(int id) throws BusinessErrorException {

        LOG.debug("ReadClientService");

        LOG.debug("Request: id: " + id);

        if (id == 0) {

            LOG.debug("BusinessError");

            throw new BusinessErrorException(new BusinessError(2, "Please inform the client ID"));
            
        }

        ResponseReadClient response = new ResponseReadClient();

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