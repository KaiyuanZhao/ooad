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
public class Record extends IEntity {
    private String id;
    private String planId;
    private String equipmentId;
    private String engineerId;
    private Date date;
    private Integer duration;
    private String log;

    public Record() {
    }

    public Record(String id, String planId, String equipmentId, String engineerId, Date date, Integer duration, String log) {
        this.id = id;
        this.planId = planId;
        this.equipmentId = equipmentId;
        this.engineerId = engineerId;
        this.date = date;
        this.duration = duration;
        this.log = log;
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
    @Column(name = "planId", nullable = true, length = 25)
    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    @Basic
    @Column(name = "equipmentId", nullable = true, length = 25)
    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    @Basic
    @Column(name = "engineerId", nullable = true, length = 25)
    public String getEngineerId() {
        return engineerId;
    }

    public void setEngineerId(String engineerId) {
        this.engineerId = engineerId;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "duration", nullable = true)
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "log", nullable = true, length = 140)
    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        if (id != null ? !id.equals(record.id) : record.id != null) return false;
        if (planId != null ? !planId.equals(record.planId) : record.planId != null) return false;
        if (equipmentId != null ? !equipmentId.equals(record.equipmentId) : record.equipmentId != null) return false;
        if (engineerId != null ? !engineerId.equals(record.engineerId) : record.engineerId != null) return false;
        if (date != null ? !date.equals(record.date) : record.date != null) return false;
        if (duration != null ? !duration.equals(record.duration) : record.duration != null) return false;
        if (log != null ? !log.equals(record.log) : record.log != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (planId != null ? planId.hashCode() : 0);
        result = 31 * result + (equipmentId != null ? equipmentId.hashCode() : 0);
        result = 31 * result + (engineerId != null ? engineerId.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (log != null ? log.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id='" + id + '\'' +
                ", planId='" + planId + '\'' +
                ", equipmentId='" + equipmentId + '\'' +
                ", engineerId='" + engineerId + '\'' +
                ", date=" + date +
                ", duration=" + duration +
                ", log='" + log + '\'' +
                '}';
    }
}
