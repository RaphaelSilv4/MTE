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
@Table(name = "address")
public class Address implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    @Column(name = "id")
    private Integer id;
    @Column(name = "cep")
    private Integer cep;
    @Column(name = "house_number")
    private Integer houseNumber;
    @Column(name = "street")
    private String street;
    @Column(name = "district")
    private String district;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;

    @JsonIgnore
    @OneToMany(mappedBy = "addressId")
    private List<User> userList;

    public Address() {}

    public Integer getId() {
        return id;
    }
    public Integer getCep() {
        return cep;
    }
    public Integer getHouseNumber() {
        return houseNumber;
    }
    public String getStreet() {
        return street;
    }
    public String getDistrict() {
        return district;
    }
    public String getState() {
        return state;
    }
    public String getCity() {
        return city;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String toJson() {
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            return ow.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    private static class Builder{
        private Address address;

        public Builder(){ address = new Address();}
        public Builder withId (Integer id){
            address.id = id;
            return this;
        }
        public Builder withCep (Integer cep){
            address.cep = cep;
            return this;
        }
        public Builder withHouseNumber (Integer houseNumber){
            address.houseNumber = houseNumber;
            return this;
        }
        public Builder withStreet (String street){
            address.street = street;
            return this;
        }
        public Builder withDistrict (String district){
            address.district = district;
            return this;
        }
        public Builder withCity (String city){
            address.city = city;
            return this;
        }
        public Builder withState (String state){
            address.state = state;
            return this;
        }
        public Address build(){return address;}
    }


}