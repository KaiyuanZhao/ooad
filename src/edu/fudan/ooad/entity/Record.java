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
    private String planId;
    private String equipmentId;
    private String engineerId;
    private Date date;
    private Integer duration;
    private String log;

    public Record() {
    }

    public Record(String id, String planId, String equipmentId, String engineerId, Date date, Integer duration, String log) {
        super(id);
        this.planId = planId;
        this.equipmentId = equipmentId;
        this.engineerId = engineerId;
        this.date = date;
        this.duration = duration;
        this.log = log;
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
    public String toString() {
        return "Record{" +
                "id='" + super.getId() + '\'' +
                ", planId='" + planId + '\'' +
                ", equipmentId='" + equipmentId + '\'' +
                ", engineerId='" + engineerId + '\'' +
                ", date=" + date +
                ", duration=" + duration +
                ", log='" + log + '\'' +
                '}';
    }
}
