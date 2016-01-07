package edu.fudan.ooad.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by Kaiyuan on 2016/1/4.
 */
@Entity
public class Record extends BaseEntity {
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
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Record)) return false;

        Record record = (Record) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(planId, record.planId)
                .append(equipmentId, record.equipmentId)
                .append(engineerId, record.engineerId)
                .append(date, record.date)
                .append(duration, record.duration)
                .append(log, record.log)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(planId)
                .append(equipmentId)
                .append(engineerId)
                .append(date)
                .append(duration)
                .append(log)
                .toHashCode();
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
