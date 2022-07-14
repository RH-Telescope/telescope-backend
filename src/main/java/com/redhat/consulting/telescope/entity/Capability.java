package com.redhat.consulting.telescope.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.sql.Timestamp;

@Table
@NamedQuery(
        name = "Capability.findAll",
        query = "SELECT c FROM Capability c ORDER BY c.name",
        hints = @QueryHint(name = "org.hibernate.cacheable", value = "false"))
public class Capability {
    @Id
    @GeneratedValue
    public Integer id;

    @Column
    public String name;

    @Column(name = "domain_id")
    @ManyToOne
    @JoinColumn(name = "id")
    public Domain domain;

    @Column(name = "flag_id")
    @ManyToOne
    @JoinColumn(name = "id")
    public Flag flag;

    @Column
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

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public Flag getFlag() {
        return flag;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Transient
    public String getFlagName() {
        if (getFlag() != null) {
            return getFlag().getName();
        }

        return null;
    }
}
