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

        // Setting up first domain
        List<CapabilityModel> capabilities1 = new ArrayList<>();
        CapabilityModel capability11 = new CapabilityModel("Capability 1-1", "green");
        CapabilityModel capability12 = new CapabilityModel("Capability 1-2", "red");

        capabilities1.add(capability11);
        capabilities1.add(capability12);

        DomainModel domain1 = new DomainModel();
        domain1.name = "Secure Code";
        domain1.flag = getFlag(capabilities1);
        domain1.capabilities = capabilities1;


        // Setting up second domain
        List<CapabilityModel> capabilities2 = new ArrayList<>();
        CapabilityModel capability21 = new CapabilityModel("Capability 2-1", "green");
        CapabilityModel capability22 = new CapabilityModel("Capability 2-2", "green");

        capabilities2.add(capability21);
        capabilities2.add(capability22);

        DomainModel domain2 = new DomainModel();
        domain2.name = "Secure Infrastructure";
        domain2.flag = getFlag(capabilities2);
        domain2.capabilities = capabilities2;


        // Adding domains to set
        domains.add(domain1);
        domains.add(domain2);


        return domains;
    }

    /**
     *
     * @param capabilities
     * @return
     */
    private String getFlag(List<CapabilityModel> capabilities) {
        return capabilities
                .stream()
                .map(CapabilityModel::getFlag)
                .collect(Collectors.toList())
                .contains("red") ? "red" : "green";
    }
}
