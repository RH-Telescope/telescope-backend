package com.redhat.consulting.telescope.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;

@Table
@NamedQuery(
        name = "Domain.findAll",
        query = "SELECT d FROM Domain d ORDER BY d.name",
        hints = @QueryHint(name = "org.hibernate.cacheable", value = "false"))
public class Domain {
    @Id
    @GeneratedValue
    public Integer id;

    @Column
    public String name;

    @Column
    @ManyToOne
    public List<Capability> capabilities;

    @Column
    public Timestamp createdAt;
}
