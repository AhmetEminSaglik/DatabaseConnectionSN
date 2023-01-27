package org.ahmeteminsaglik.business.registeredobject.base;

import org.ahmeteminsaglik.dataaccess.abstracts.BaseDAO;

import java.util.ArrayList;
import java.util.List;

public abstract class RegisteredObject<T> {
    protected List<T> list = null;
    protected BaseDAO<T> dao;

    public RegisteredObject(BaseDAO<T> dao) {
        this.dao = dao;
    }

    public abstract T getByEnum(Enum<?> em);

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public BaseDAO<T> getDao() {
        return dao;
    }

    public void setDao(BaseDAO<T> dao) {
        this.dao = dao;
    }

    public void printHintInCaseOfRequestedDataIsNotFound() {

    }
}
