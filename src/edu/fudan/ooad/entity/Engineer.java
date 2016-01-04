package edu.fudan.ooad.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Kaiyuan on 2016/1/4.
 */
@Entity
public class Engineer extends IEntity {
    private String id;
    private String name;

    public Engineer() {
    }

    public Engineer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @Column(name = "id", nullable = false, length = 25)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        if (o == null || getClass() != o.getClass()) return false;

        Engineer engineer = (Engineer) o;

        if (id != null ? !id.equals(engineer.id) : engineer.id != null) return false;
        if (name != null ? !name.equals(engineer.name) : engineer.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Engineer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}