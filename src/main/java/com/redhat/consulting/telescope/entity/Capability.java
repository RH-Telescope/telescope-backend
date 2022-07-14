package com.redhat.consulting.telescope.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
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
}
