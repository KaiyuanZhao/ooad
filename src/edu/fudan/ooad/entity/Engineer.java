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
    public String toString() {
        return "Engineer{" +
                "id='" + super.getId() + '\'' +
                ", name='" + name + '\'' +
                "}";
    }
}
