package edu.fudan.ooad.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Kaiyuan on 2016/1/4.
 */
@Entity
public class Type extends IEntity {
    private String name;

    public Type() {
    }

    public Type(String id, String name) {
        super(id);
        this.name = name;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id='" + super.getId() + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
