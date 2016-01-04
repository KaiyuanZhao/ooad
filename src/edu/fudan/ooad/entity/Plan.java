package edu.fudan.ooad.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Kaiyuan on 2016/1/4.
 */
@Entity
public class Plan extends IEntity {
    private String id;
    private String typeId;
    private int space;
    private String name;
    private String comment;

    public Plan() {
    }

    public Plan(String id, String typeId, int space, String name, String comment) {
        this.id = id;
        this.typeId = typeId;
        this.space = space;
        this.name = name;
        this.comment = comment;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plan plan = (Plan) o;

        if (space != plan.space) return false;
        if (id != null ? !id.equals(plan.id) : plan.id != null) return false;
        if (typeId != null ? !typeId.equals(plan.typeId) : plan.typeId != null) return false;
        if (name != null ? !name.equals(plan.name) : plan.name != null) return false;
        if (comment != null ? !comment.equals(plan.comment) : plan.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + space;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id='" + id + '\'' +
                ", typeId='" + typeId + '\'' +
                ", space=" + space +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
