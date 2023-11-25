package com.mte2023.spring_mte.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "password")
    private String password;
    @Column(name = "address_id")
    private Integer addressID;
    @JsonIgnore
    @OneToMany(mappedBy = "userId")
    private List<CollectionOrder> collectionOrdersList;
    @ManyToOne
    @JoinColumn(name = "address_id",referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Address addressId;
    public User() {}

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CollectionOrder> getCollectionOrdersList() {
        return collectionOrdersList;
}
 public void setCollectionOrdersList(List<CollectionOrder> collectionOrdersList) {
        this.collectionOrdersList = collectionOrdersList;
    }
    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }


    public String toJson() {
    try {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(this);
    } catch (JsonProcessingException e) {
        throw new RuntimeException(e);
    }
}
public static class Builder{
    private User user;

    public Builder(){
        user = new User();
    }
    public Builder withId(Integer id){
        user.id = id;
        return this;
    }
    public  Builder withName(String name){
        user.name = name;
        return this;
    }
    public Builder withEmail(String email){
        user.email = email;
        return this;
    }
    public  Builder withPhone(String phone){
        user.phone = phone;
        return this;
    }
    public  Builder withPassword(String password){
        user.password = password;
        return this;
    }
    public Builder withAddressID(Integer addressID){
        user.addressID = addressID;
        return this;
    }
    public Builder withAddressId(Address addressId){
        user.addressId = addressId;
        return this;
    }
    public User build(){
        return user;
    }
}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}