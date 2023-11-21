
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
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    @Column(name = "moment")
    private Instant moment;

    @Column(name = "order_status")
    private Integer orderStatus; /* Tratamento Integer e interno a classe Pedido_Coleta */

    @Column(name = "description")
    private String description;

    @Column(name = "user_id")
    private Long userID;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private User userId;
    private Payment payment;

    public CollectionOrder(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }
    
    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserID(){
        return userID;
    }

    public void setUserID(Long userID){
        this.userID = userID;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
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

        public Builder withId(Long id){
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
        public Builder withOrderStatus(Integer orderStatus){
            collectionOrder.orderStatus = orderStatus;
            return this;
        }
        public Builder withUserID(Long userID){
            collectionOrder.userID = userID;
            return this;
        }
        public Builder withUserId(User userId){
            collectionOrder.userId = userId;
            return this;
        }
        public Builder withPayment(Payment payment){
            collectionOrder.payment = payment;
            return this;
        }
        public CollectionOrder build(){
            return collectionOrder;
        }
    }
    
    @Override
    public String toString() {
        return "CollectionOrder{" +
                "id=" + id +
                ", moment=" + moment +
                ", description='" + description + '\'' +
                ", userID=" + userID +
                ", userId=" + userId +
                '}';
    }
}