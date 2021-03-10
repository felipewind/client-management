package com.helesto.services;

import java.time.format.DateTimeParseException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.helesto.dto.ClientDto;
import com.helesto.exceptions.BusinessError;
import com.helesto.exceptions.BusinessErrorException;
import com.helesto.models.Client;
import com.helesto.repository.ClientRepository;
import com.helesto.utils.DateUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class ClientUpdateService {

    private static final Logger LOG = LoggerFactory.getLogger(ClientUpdateService.class.getName());

    @Inject
    ClientRepository clientRepository;

    @Transactional(rollbackOn = Exception.class)
    public ClientDto updateClientService(ClientDto request) throws BusinessErrorException {

        LOG.debug("UpdateClientService");

        if (request.getId() == 0) {
            LOG.debug("BusinessError");
            throw new BusinessErrorException(new BusinessError(2, "Please inform the client ID"));            
        }

        Client client = new Client();
        client.setId(request.getId());
        client.setName(request.getName());
        client.setEmail(request.getEmail());
        client.setPhoneNumber(request.getPhoneNumber());

        try {
            client.setBirthDate(DateUtils.stringToLocalDate(request.getBirthDate()));
        } catch (DateTimeParseException e) {
            throw new BusinessErrorException(new BusinessError(3, "Please inform the date in the format 'mm/dd/yyyy'"));
        }

        clientRepository.updateClient(client);

        return new ClientDto(client);

    }

}