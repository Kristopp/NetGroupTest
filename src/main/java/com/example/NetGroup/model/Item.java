package com.example.NetGroup.model;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;


@Entity
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    Long id;
    Long user_id;
    @Column(name = "img_url")
    String img_url;
    @Column(name = "name")
    String name;
    @Column(name = "serial")
    Long serial;
    @Column(name = "when_stored")
    LocalDateTime whenStored;
    @Column(name = "location")
    String location;
    @Column(name = "quantity")
    Integer quantity;
    @Column(name = "description")
    String description;

    public Item() {

    }

    public Item(
            String img_url,
            String name,
            Long serial,
            String location,
            Integer quantity,
            String description
    ) {
        this.name = name;
        this.serial = serial;
        this.img_url = img_url;
        this.location = location;
        this.quantity = quantity;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(String s) {
        this.id = id;
    }

    public Long user_id() {
        return user_id;
    }

    public void setImg_url() {
        this.img_url = img_url;
    }

    public String getImg_url() {
        return img_url;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public Long getSerial() {
        return serial;
    }

    public void setSerial() {
        this.serial = serial;
    }

    public void setWhenStored(LocalDateTime createdAt) {
        this.whenStored = whenStored;
    }

    public LocalDateTime getWhenStored() {
        return whenStored;
    }

    public void setLocation() {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setQuantity() {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setDescription() {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Users{ " +
                "id=" + id +
                ", name " + name + '\'' +
                ", user_id, " + user_id + '\'' +
                ", img_url " + img_url + '\'' +
                ", whenStored " + whenStored + '\'' +
                ", location" + location + '\'' +
                ", quantity" + quantity + '\'' +
                ", description" + description + '\'' +
                "}";
    }


}
