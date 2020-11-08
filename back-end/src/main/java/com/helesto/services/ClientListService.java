package com.helesto.services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.google.gson.Gson;
import com.helesto.api.ResponseClient;
import com.helesto.api.ResponseListClient;
import com.helesto.exceptions.BusinessErrorException;
import com.helesto.repository.ClientRepository;
import com.helesto.utils.DateUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class ClientListService {

    private static final Logger LOG = LoggerFactory.getLogger(ClientUpdateService.class.getName());

    @Inject
    ClientRepository clientRepository;

    public ResponseListClient listClientService() throws BusinessErrorException {

        LOG.debug("listClientService");

        List<ResponseClient> listClient = new ArrayList<>();

        clientRepository.findAll().forEach(client -> {
            listClient.add(new ResponseClient(client.getId(), client.getName(),
                    DateUtils.localDateToStringMmDdYyyy(client.getBirthDate()), client.getEmail(),
                    client.getPhoneNumber()));
        });

        ResponseListClient response = new ResponseListClient();

        response.setListClient(listClient);

        Gson gson = new Gson();
        String json = gson.toJson(response);
        LOG.debug("Response: " + json);

        return response;
    }

}