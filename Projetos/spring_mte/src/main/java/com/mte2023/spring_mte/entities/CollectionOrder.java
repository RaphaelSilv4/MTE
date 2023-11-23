
package com.mte2023.spring_mte.entities;


import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectWriter;

import jakarta.persistence.*;

@Entity
@Table(name = "collection_order")
public class CollectionOrder implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    @Column(name = "id")
    private Integer id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    @Column(name = "moment")
    private Instant moment;

    @Column(name = "description")
    private String description;

    @Column(name = "user_id")
    private Integer userID;
    @Column(name = "address_id")
    private Integer addressID;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private User userId;

    @ManyToOne
    @JoinColumn(name = "address_id",referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Address addressId;

 //   private Payment payment;
    public CollectionOrder(){}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUserID(){
        return userID;
    }
    public void setUserID(Integer userID){
        this.userID = userID;
    }
    public User getUserId() {
        return userId;
    }
    public void setUserId(User userId) {
        this.userId = userId;
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

    /*
        public Payment getPayment() {
            return payment;
        }

        public void setPayment(Payment payment) {
            this.payment = payment;
        }
        */
    public String toJson() {
    try {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(this);
    } catch (JsonProcessingException e) {
        throw new RuntimeException(e);
    }
}


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CollectionOrder other = (CollectionOrder) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    private static class Builder{

        private CollectionOrder collectionOrder;

        public Builder(){ collectionOrder = new CollectionOrder();}

        public Builder withId(Integer id){
            collectionOrder.id = id;
            return this;
        }
        public Builder withMoment(Instant moment){
            collectionOrder.moment = moment;
            return this;
        }
        public Builder withDescription(String description){
            collectionOrder.description = description;
            return this;
        }

        public Builder withUserID(Integer userID){
            collectionOrder.userID = userID;
            return this;
        }
        public Builder withUserId(User userId){
            collectionOrder.userId = userId;
            return this;
        }
        public Builder withAddressID(Integer addressID){
            collectionOrder.addressID = addressID;
            return this;
        }
        public Builder withAddressId(Address addressId){
            collectionOrder.addressId = addressId;
            return this;
        }
        public CollectionOrder build(){
            return collectionOrder;
        }

    }


}
