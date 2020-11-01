package com.helesto.services;

import javax.enterprise.context.RequestScoped;

import com.google.gson.Gson;
import com.helesto.api.RequestInsertClient;
import com.helesto.api.ResponseInsertClient;
import com.helesto.exceptions.BusinessError;
import com.helesto.exceptions.BusinessErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class ClientInsertService {

    private static final Logger LOG = LoggerFactory.getLogger(ClientInsertService.class.getName());

    public ResponseInsertClient insertClientService(RequestInsertClient request) throws BusinessErrorException {

        LOG.debug("InsertClientService");

        Gson gson = new Gson();
        String json = gson.toJson(request);
        LOG.debug("Request: " + json);

        if (request.getName() == null || request.getName().equals("")) {

            LOG.debug("BusinessError");

            throw new BusinessErrorException(new BusinessError(2, "Please inform the client name"));
            
        }

        ResponseInsertClient response = new ResponseInsertClient();

        response.setClientId(1);        

        json = gson.toJson(response);
        LOG.debug("Response: " + json);

        return response;
    }

}