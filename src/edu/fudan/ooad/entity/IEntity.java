package edu.fudan.ooad.entity;

import edu.fudan.ooad.operation.BaseOperation;
import edu.fudan.ooad.operation.IOperation;

/**
 * Created by Kaiyuan on 2016/1/4.
 */
public abstract class IEntity implements IOperation {

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
}
