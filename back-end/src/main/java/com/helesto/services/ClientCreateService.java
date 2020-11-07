package com.helesto.services;

import java.time.format.DateTimeParseException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.google.gson.Gson;
import com.helesto.api.RequestCreateClient;
import com.helesto.api.ResponseCreateClient;
import com.helesto.exceptions.BusinessError;
import com.helesto.exceptions.BusinessErrorException;
import com.helesto.models.Client;
import com.helesto.repository.ClientRepository;
import com.helesto.utils.DateUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class ClientCreateService {

    private static final Logger LOG = LoggerFactory.getLogger(ClientCreateService.class.getName());

    @Inject
    ClientRepository clientRepository;

    @Transactional
    public ResponseCreateClient CreateClientService(RequestCreateClient request) throws BusinessErrorException {

        LOG.debug("CreateClientService");

        Gson gson = new Gson();
        String json = gson.toJson(request);
        LOG.debug("Request: " + json);

        if (request.getName() == null || request.getName().equals("")) {

            LOG.debug("BusinessError");

            throw new BusinessErrorException(new BusinessError(2, "Please inform the client name"));

        }

        Client client = new Client();

        client.setName(request.getName());

        client.setEmail(request.getEmail());

        client.setPhoneNumber(request.getPhoneNumber());

        try {
            client.setBirthDate(DateUtils.stringToLocalDate(request.getBirthDate()));
        } catch (DateTimeParseException e) {
            throw new BusinessErrorException(new BusinessError(3, "Please inform the date in the format 'mm/dd/yyyy'"));
        }

        clientRepository.persistClient(client);

        ResponseCreateClient response = new ResponseCreateClient();

        response.setid(client.getId());

        json = gson.toJson(response);
        LOG.debug("Response: " + json);

        return response;
    }

}