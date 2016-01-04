package edu.fudan.ooad.entity;

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

        if (equipment != null ? !equipment.equals(task.equipment) : task.equipment != null) return false;
        if (plan != null ? !plan.equals(task.plan) : task.plan != null) return false;
        return date != null ? date.equals(task.date) : task.date == null;

    }

    @Override
    public int hashCode() {
        int result = equipment != null ? equipment.hashCode() : 0;
        result = 31 * result + (plan != null ? plan.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
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
