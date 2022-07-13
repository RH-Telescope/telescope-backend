package com.redhat.consulting.telescope.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class CapabilityModel {

    public String name;
    public String status;

    public CapabilityModel() {
    }

    public CapabilityModel(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

