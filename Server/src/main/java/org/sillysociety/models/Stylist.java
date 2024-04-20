package org.sillysociety.models;

import jakarta.persistence.*;
@Entity
@Table(name = "Stylist")
@NamedQuery(name = "Stylist.getAll", query = "SELECT s from Stylist s")
public class Stylist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", length = 255)
    private String name;
    @Column(name="isDeleted")
    private Boolean isDeleted;
    public Stylist(Integer id, String name, Boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.isDeleted = isDeleted;
    }
    public Stylist() {}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Boolean getDeleted() {
        return isDeleted;
    }
    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}