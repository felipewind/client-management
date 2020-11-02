package com.helesto.services;

import javax.enterprise.context.RequestScoped;

import com.google.gson.Gson;
import com.helesto.api.RequestCreateClient;
import com.helesto.api.ResponseCreateClient;
import com.helesto.exceptions.BusinessError;
import com.helesto.exceptions.BusinessErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class ClientCreateService {

    private static final Logger LOG = LoggerFactory.getLogger(ClientCreateService.class.getName());

    public ResponseCreateClient CreateClientService(RequestCreateClient request) throws BusinessErrorException {

        LOG.debug("CreateClientService");

        Gson gson = new Gson();
        String json = gson.toJson(request);
        LOG.debug("Request: " + json);

        if (request.getName() == null || request.getName().equals("")) {

            LOG.debug("BusinessError");

            throw new BusinessErrorException(new BusinessError(2, "Please inform the client name"));
            
        }

        ResponseCreateClient response = new ResponseCreateClient();

        response.setid(1);        

        json = gson.toJson(response);
        LOG.debug("Response: " + json);

        return response;
    }

}