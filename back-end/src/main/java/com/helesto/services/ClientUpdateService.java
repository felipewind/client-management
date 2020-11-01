package com.helesto.services;

import javax.enterprise.context.RequestScoped;

import com.google.gson.Gson;
import com.helesto.api.RequestUpdateClient;
import com.helesto.exceptions.BusinessError;
import com.helesto.exceptions.BusinessErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class ClientUpdateService {

    private static final Logger LOG = LoggerFactory.getLogger(ClientUpdateService.class.getName());

    public void updateClientService(RequestUpdateClient request) throws BusinessErrorException {

        LOG.debug("UpdateClientService");

        Gson gson = new Gson();
        String json = gson.toJson(request);
        LOG.debug("Request: " + json);

        if (request.getid() == 0) {

            LOG.debug("BusinessError");

            throw new BusinessErrorException(new BusinessError(2, "Please inform the client ID"));
            
        }
    }

}