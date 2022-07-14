package com.redhat.consulting.telescope.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.redhat.consulting.telescope.dao.DomainDAO;
import com.redhat.consulting.telescope.entity.Capability;
import com.redhat.consulting.telescope.entity.Domain;
import com.redhat.consulting.telescope.model.CapabilityModel;
import com.redhat.consulting.telescope.model.DomainModel;

@Path("/domains")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class DomainResource {

    @Inject
    DomainDAO domainDAO;

    public DomainResource() {
    }

    /**
     *
     * @return the list of all domains
     */
    @GET
    public Set<DomainModel> get() {
        // TODO: For v1 POC, returning a static set of Domains
        Set<DomainModel> domains = new LinkedHashSet<>();

        List<Domain> domainEntities = domainDAO.getAllDomains();

        for (Domain domainEntity : domainEntities) {
            domains.add(getDomainModel(domainEntity));
        }

        return domains;
    }

    /**
     *
     * @param capabilities
     * @return
     */
    private String getFlag(List<Capability> capabilities) {
        return capabilities
                .stream()
                .map(Capability::getFlagName)
                .collect(Collectors.toList())
                .contains("red") ? "red" : "green";
    }

    private DomainModel getDomainModel(Domain domainEntity) {
        DomainModel domain = new DomainModel();

        domain.capabilities = new ArrayList<>();

        for (Capability capabilityEntity : domainEntity.capabilities) {
            domain.capabilities.add(getCapabilityModel(capabilityEntity));
        }

        domain.name = domainEntity.name;
        domain.flag = getFlag(domainEntity.capabilities);

        return domain;
    }

    private CapabilityModel getCapabilityModel(Capability capabilityEntity) {
        CapabilityModel capability = new CapabilityModel();

        capability.name = capabilityEntity.name;
        capability.flag = capabilityEntity.flag.name;

        return capability;
    }
}
