package edu.fudan.ooad;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Kaiyuan on 2016/1/4.
 */
@Entity
public class Equipment {
    private String id;
    private String typeId;
    private String model;
    private String location;
    private Date time;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipment equipment = (Equipment) o;

        if (id != null ? !id.equals(equipment.id) : equipment.id != null) return false;
        if (typeId != null ? !typeId.equals(equipment.typeId) : equipment.typeId != null) return false;
        if (model != null ? !model.equals(equipment.model) : equipment.model != null) return false;
        if (location != null ? !location.equals(equipment.location) : equipment.location != null) return false;
        if (time != null ? !time.equals(equipment.time) : equipment.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id='" + id + '\'' +
                ", typeId='" + typeId + '\'' +
                ", model='" + model + '\'' +
                ", location='" + location + '\'' +
                ", time=" + time +
                '}';
    }
}
