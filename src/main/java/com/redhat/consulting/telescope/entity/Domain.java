package com.redhat.consulting.telescope.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table
@NamedQuery(
        name = "Domain.findAll",
        query = "SELECT d FROM Domain d ORDER BY d.name",
        hints = @QueryHint(name = "org.hibernate.cacheable", value = "false"))
public class Domain {
    @Id
    @GeneratedValue
    public Integer id;

    @Column(name = "description")
    public String name;

    @OneToMany(mappedBy = "domain")
    public List<Capability> capabilities;

    @Column(name = "created_at")
    public Timestamp createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Capability> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(List<Capability> capabilities) {
        this.capabilities = capabilities;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
