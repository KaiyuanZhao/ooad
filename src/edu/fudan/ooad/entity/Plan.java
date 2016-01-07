package edu.fudan.ooad.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Kaiyuan on 2016/1/4.
 */
@Entity
public class Plan extends IEntity {
    private String typeId;
    private int space;
    private String name;
    private String comment;

    public Plan() {
    }

    public Plan(String id, String typeId, int space, String name, String comment) {
        super(id);
        this.typeId = typeId;
        this.space = space;
        this.name = name;
        this.comment = comment;
    }

    @Basic
    @Column(name = "typeId", nullable = true, length = 25)
    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "space", nullable = false)
    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "comment", nullable = true, length = 45)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id='" + super.getId() + '\'' +
                ", typeId='" + typeId + '\'' +
                ", space=" + space +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
