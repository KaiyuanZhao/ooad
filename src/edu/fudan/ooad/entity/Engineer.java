package edu.fudan.ooad.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Kaiyuan on 2016/1/4.
 */
@Entity
public class Engineer extends BaseEntity {
    private String name;

    public Engineer() {
    }

    public Engineer(String id, String name) {
        super(id);
        this.name = name;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Engineer)) return false;

        Engineer engineer = (Engineer) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(name, engineer.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(name)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Engineer{" +
                "id='" + super.getId() + '\'' +
                ", name='" + name + '\'' +
                "}";
    }
}
