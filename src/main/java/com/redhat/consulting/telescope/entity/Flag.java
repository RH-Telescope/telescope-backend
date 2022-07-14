package com.redhat.consulting.telescope.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "flag")
@NamedQuery(
        name = "Flag.findAll",
        query = "SELECT f FROM Flag f ORDER BY f.name",
        hints = @QueryHint(name = "org.hibernate.cacheable", value = "false"))
public class Flag {
    @Id
    @GeneratedValue
    public Integer id;

    @Column
    public String name;

    @Column
    public Timestamp createdAt;
}
