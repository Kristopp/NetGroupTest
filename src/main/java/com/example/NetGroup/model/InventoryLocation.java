package com.example.NetGroup.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity(name = "inventory")
public class InventoryLocation implements Serializable {
    @Id
    @Column(name = "id" )
    Long id;
    @Column(name = "uniqueKey", unique = true)
    private UUID uniqueKey;
    @Column(name = "name")
    private String name;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "parent_id")
    private Integer parentId;

    public InventoryLocation() {
    }

    public InventoryLocation(
            Long id,
            String name,
            String createdBy,
            Integer parentId
    ) {
        this.uniqueKey = uniqueKey;
        this.id = id;
        this.name = name;
        this.createdBy = createdBy;
        this.parentId = parentId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(UUID uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy() {
        this.name = createdBy;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId() {
        this.parentId = parentId;
    }


    @Override
    public String toString() {
        return "new Location{ " + "n/" +
                "id= " + id + "/" +
                "name= " + name + "n/" +
                "createdBy= " + createdBy + "n/" +
                "parentId= " + parentId + "n/" +
                "}";
    }
}
