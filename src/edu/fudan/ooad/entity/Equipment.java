package edu.fudan.ooad.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Kaiyuan on 2016/1/4.
 */
@Entity
public class Equipment extends IEntity {
    private String typeId;
    private String model;
    private String location;
    private Date time;

    public Equipment() {
    }

    public Equipment(String id, String typeId, String model, String location, Date time) {
        super(id);
        this.typeId = typeId;
        this.model = model;
        this.location = location;
        this.time = time;
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
    @Column(name = "model", nullable = true, length = 45)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "location", nullable = true, length = 45)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "time", nullable = false)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id='" + super.getId() + '\'' +
                ", typeId='" + typeId + '\'' +
                ", model='" + model + '\'' +
                ", location='" + location + '\'' +
                ", time=" + time +
                '}';
    }
}
