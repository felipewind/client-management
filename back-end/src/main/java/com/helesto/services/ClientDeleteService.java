package com.helesto.services;

import javax.enterprise.context.RequestScoped;

import com.helesto.exceptions.BusinessError;
import com.helesto.exceptions.BusinessErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class ClientDeleteService {

    private static final Logger LOG = LoggerFactory.getLogger(ClientDeleteService.class.getName());

    public void deleteClientService(int clientId) throws BusinessErrorException {

        LOG.debug("DeleteClientService");

        LOG.debug("Request: clientId: " + clientId);

        if (clientId == 0) {

            LOG.debug("BusinessError");

            throw new BusinessErrorException(new BusinessError(2, "Please inform the client ID"));
            
        }
    }

}