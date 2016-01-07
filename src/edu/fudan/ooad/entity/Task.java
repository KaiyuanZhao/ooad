package edu.fudan.ooad.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.Date;

/**
 * Created by Kaiyuan on 2016/1/4.
 */
public class Task {
    private Equipment equipment;
    private Plan plan;
    private Date date;

    public Task() {
    }

    public Task(Equipment equipment, Plan plan, Date date) {
        this.equipment = equipment;
        this.plan = plan;
        this.date = date;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Task)) return false;

        Task task = (Task) o;

        return new EqualsBuilder()
                .append(equipment, task.equipment)
                .append(plan, task.plan)
                .append(date, task.date)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(equipment)
                .append(plan)
                .append(date)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Task{" +
                "equipment=" + equipment +
                ", plan=" + plan +
                ", date=" + date +
                '}';
    }
}
