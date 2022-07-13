package com.redhat.consulting.telescope.model;

import java.util.List;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class DomainModel {

    public String name;
    public List<CapabilityModel> capabilities;
    public String flag;

    public DomainModel() {
    }

    public DomainModel(String name, List<CapabilityModel> capabilities, String flag) {
        this.name = name;
        this.capabilities = capabilities;
        this.flag = flag;
    }
}
