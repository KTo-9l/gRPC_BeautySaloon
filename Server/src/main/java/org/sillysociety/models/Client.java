package org.sillysociety.models;

import jakarta.persistence.*;
@Entity
@Table(name = "client")
@NamedQuery(name = "Client.getAll", query = "SELECT c from Client c")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", length = 255)
    private String name;
    @ManyToOne
    @JoinColumn(name = "stylist")
    private Stylist stylist;
    @Column(name = "isDeleted")
    private Boolean isDeleted;

    public Client(Integer id, String name, Stylist stylist, Boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.stylist = stylist;
        this.isDeleted = isDeleted;
    }
    public Client() {}
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
    public Stylist getStylist() {
        return stylist;
    }
    public void setIdStylist(Stylist stylist) {
        this.stylist = stylist;
    }
    public Boolean getDeleted() {
        return isDeleted;
    }
    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}