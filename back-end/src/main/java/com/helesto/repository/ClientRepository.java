package com.helesto.repository;

import java.util.Collections;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

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
 
}
