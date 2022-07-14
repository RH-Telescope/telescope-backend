package com.redhat.consulting.telescope.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class CapabilityModel {

    public String name;
    public String flag;

    public CapabilityModel() {
    }

    public CapabilityModel(String name, String flag) {
        this.name = name;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}

