package com.helesto.repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.helesto.exceptions.BusinessError;
import com.helesto.exceptions.BusinessErrorException;
import com.helesto.models.Client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class ClientRepository {

    private static final Logger LOG = LoggerFactory.getLogger(ClientRepository.class.getName());

    @Inject
    EntityManager entityManager;

    public List<Client> findAll() {

        TypedQuery<Client> query = entityManager.createNamedQuery("Client.findAll", Client.class);

        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList();
        } catch (PersistenceException e) {
            LOG.error("PersistenceException", e);
            throw e;
        }
    }

    public void persistClient(Client client) {
        try {
            entityManager.persist(client);
        } catch (PersistenceException e) {
            LOG.error("PersistenceException", e);
            throw e;
        }
    }

    public Optional<Client> findClientById(int id) {
        try {
            Client client = entityManager.find(Client.class, id);
            return Optional.ofNullable(client);
        } catch (PersistenceException e) {
            LOG.error("PersistenceException", e);
            throw e;
        }
    }

    public void removeClient(int id) throws BusinessErrorException {
        try {
            Client client = findClientById(id).orElseThrow(() -> new BusinessErrorException(
                    new BusinessError(3, "Client with id of " + id + " does not exist")));
            entityManager.remove(client);
        } catch (PersistenceException e) {
            LOG.error("PersistenceException", e);
            throw e;
        }
    }

    public void updateClient(Client client) throws BusinessErrorException {
        try {
            Client clientToUpdate = findClientById(client.getId()).orElseThrow(() -> new BusinessErrorException(
                    new BusinessError(3, "Client with id of " + client.getId() + " does not exist")));
            clientToUpdate.setBirthDate(client.getBirthDate());
            clientToUpdate.setEmail(client.getEmail());
            clientToUpdate.setName(client.getName());
            clientToUpdate.setPhoneNumber(client.getPhoneNumber());
        } catch (PersistenceException e) {
            LOG.error("PersistenceException", e);
            throw e;
        }
    }

}
