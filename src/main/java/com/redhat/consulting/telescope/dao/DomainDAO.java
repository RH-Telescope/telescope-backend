package com.redhat.consulting.telescope.dao;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import java.util.List;

import com.redhat.consulting.telescope.entity.Domain;
import org.jboss.logging.Logger;

@Dependent
public class DomainDAO {

    private static final Logger LOGGER = Logger.getLogger(DomainDAO.class.getName());

    @Inject
    EntityManager entityManager;

    public List<Domain> getAllDomains() {
        return entityManager
                .createNamedQuery("Domain.findAll", Domain.class)
                .getResultList();
    }
}
