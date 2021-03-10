package com.helesto.services;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.helesto.exceptions.BusinessError;
import com.helesto.exceptions.BusinessErrorException;
import com.helesto.repository.ClientRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class ClientDeleteService {

    private static final Logger LOG = LoggerFactory.getLogger(ClientDeleteService.class.getName());

    @Inject
    ClientRepository clientRepository;

    @Transactional(rollbackOn = Exception.class)
    public void deleteClientService(int id) throws BusinessErrorException {

        LOG.debug("DeleteClientService");

        LOG.debug("Request: id: " + id);

        if (id == 0) {
            LOG.debug("BusinessError");
            throw new BusinessErrorException(new BusinessError(2, "Please inform the client ID"));
        }

        clientRepository.removeClient(id);

    }

}