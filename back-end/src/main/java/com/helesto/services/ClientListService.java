package com.helesto.services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import com.google.gson.Gson;
import com.helesto.api.ResponseClient;
import com.helesto.api.ResponseListClient;
import com.helesto.exceptions.BusinessErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class ClientListService {

    private static final Logger LOG = LoggerFactory.getLogger(ClientUpdateService.class.getName());

    public ResponseListClient listClientService() throws BusinessErrorException {

        LOG.debug("listClientService");

        List<ResponseClient> listClient = new ArrayList<>();

        listClient.add(new ResponseClient(1, "John", "05.10.1980", "john-smith@emailtest.com", 5561984841234l));

        listClient.add(new ResponseClient(2, "Maria", "05.11.1950", "maria-smith@emailtest.com", 557458941234l));

        listClient.add(new ResponseClient(3, "Peter", "10.12.1970", "peter-abith@emailtest.com", 55745468781234l));

        ResponseListClient response = new ResponseListClient();

        response.setListClient(listClient);

        Gson gson = new Gson();
        String json = gson.toJson(response);
        LOG.debug("Response: " + json);

        return response;
    }


}