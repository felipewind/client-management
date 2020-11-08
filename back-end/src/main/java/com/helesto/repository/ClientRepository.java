package com.helesto.repository;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.helesto.exceptions.BusinessError;
import com.helesto.exceptions.BusinessErrorException;
import com.helesto.models.Client;

@RequestScoped
public class ClientRepository {

    @Inject
    EntityManager entityManager;

    public List<Client> findAll() {
        return entityManager.createNamedQuery("Client.findAll", Client.class).getResultList();
    }

    public void persistClient(Client client) {
        entityManager.persist(client);
    }

    public Optional<Client> findClientById(int id) {
        Client client = entityManager.find(Client.class, id);
        return Optional.ofNullable(client);
    }

    public void removeClient(int id) throws BusinessErrorException {
        Client client = findClientById(id).orElseThrow(
                () -> new BusinessErrorException(new BusinessError(3, "Client with id of " + id + " does not exist")));
        entityManager.remove(client);

    }

    public void updateClient(Client client) throws BusinessErrorException {
        Client clientToUpdate = findClientById(client.getId()).orElseThrow(() -> new BusinessErrorException(
                new BusinessError(3, "Client with id of " + client.getId() + " does not exist")));
        clientToUpdate.setBirthDate(client.getBirthDate());
        clientToUpdate.setEmail(client.getEmail());
        clientToUpdate.setName(client.getName());
        clientToUpdate.setPhoneNumber(client.getPhoneNumber());
    }

}
