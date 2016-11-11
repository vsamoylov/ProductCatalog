package com.springapp.mvc.domain;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.List;

/**
 * Created by Max on 13.06.2016.
 */
@Entity
@Table(name="object_types")
public class ObjectType {
    @Id
    @GeneratedValue
    @Column(name="object_type_id")
    private int objectTypeId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectId")
    private List<DataObject> dataObjects;

    public ObjectType() {
    }

    public int getObjectTypeId() {
        return objectTypeId;
    }

    public void setObjectTypeId(int objectTypeId) {
        this.objectTypeId = objectTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DataObject> getDataObjects() {
        return dataObjects;
    }

    public void setDataObjects(List<DataObject> dataObjects) {
        this.dataObjects = dataObjects;
    }
}
