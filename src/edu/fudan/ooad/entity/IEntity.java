package edu.fudan.ooad.entity;

import edu.fudan.ooad.operation.BaseOperation;
import edu.fudan.ooad.operation.IOperation;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Kaiyuan on 2016/1/4.
 */
@MappedSuperclass
public abstract class IEntity implements IOperation {
    private String id;

    public IEntity() {
    }

    public IEntity(String id) {
        this.id = id;
    }

    @Id
    @Column(name = "id", nullable = false, length = 25)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void insert() {
        BaseOperation.insert(this);
    }

    @Override
    public void update() {
        BaseOperation.update(this);
    }

    @Override
    public void delete() {
        BaseOperation.delete(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IEntity)) return false;

        IEntity iEntity = (IEntity) o;

        return id != null ? id.equals(iEntity.id) : iEntity.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "IEntity{" +
                "id='" + id + '\'' +
                '}';
    }
}
