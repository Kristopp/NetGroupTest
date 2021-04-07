package com.example.NetGroup.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "inventory")
public class InventoryLocation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;
    @Column(name = "name")
    private String name;
    @Column(name = "createdBy")
    private String createdBy;
    private Integer parentId;

    public InventoryLocation() {
    }

    public InventoryLocation(
            long id,
            String name,
            String createdBy,
            Integer parentId
    ) {
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
        return "new Location{ " + "/" +
                "id= " + id + "/" +
                "name= " + name + "/" +
                "createdBy= " + createdBy + "/" +
                "}";
    }
}
