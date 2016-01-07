package edu.fudan.ooad.entity;

import edu.fudan.ooad.operation.DatabaseOperation;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Kaiyuan on 2016/1/4.
 */
@MappedSuperclass
public abstract class BaseEntity implements IDatabase, IEntity {
    private String id;

    public BaseEntity() {
    }

    public BaseEntity(String id) {
        this.id = id;
    }

    @Id
    @Column(name = "id", nullable = false, length = 25)
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void insert() {
        DatabaseOperation.insert(this);
    }

    @Override
    public void update() {
        DatabaseOperation.update(this);
    }

    @Override
    public void delete() {
        DatabaseOperation.delete(this);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof BaseEntity)) return false;

        BaseEntity that = (BaseEntity) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id='" + id + '\'' +
                '}';
    }
}
