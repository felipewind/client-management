package com.helesto.services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.helesto.dto.ClientDto;
import com.helesto.exceptions.BusinessErrorException;
import com.helesto.repository.ClientRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class ClientListService {

    private static final Logger LOG = LoggerFactory.getLogger(ClientUpdateService.class.getName());

    @Inject
    ClientRepository clientRepository;

    public ClientDto[] listClientService() throws BusinessErrorException {

        LOG.debug("listClientService");

        List<ClientDto> listClient = new ArrayList<>();

        clientRepository.findAll().forEach(client -> {
            listClient.add(new ClientDto(client));
        });

        ClientDto[] responseClientArray = listClient.toArray(new ClientDto[0]);

        return responseClientArray;
    }

}