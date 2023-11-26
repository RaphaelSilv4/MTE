package com.mte2023.spring_mte.entities;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_account")
public class UserAccount implements Serializable{

    @Id
    @Column(name="user_id")
    private Integer userId;
    @OneToOne
    @PrimaryKeyJoinColumn(name="user_id", referencedColumnName = "id")
    private User owner;
    @Column(name = "balance")
    private Float balance;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userid) {
        this.userId = userid;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
    public static class Builder{
        private UserAccount userAccount;

        public Builder(){userAccount = new UserAccount();}
        public Builder withUserId(Integer userId){
            userAccount.userId = userId;
            return this;
        }
        public Builder withOwner (User owner){
            userAccount.owner = owner;
            return this;
        }
        public Builder withBalance (Float balance){
            userAccount.balance = balance;
            return this;
        }
        public UserAccount build(){return userAccount;}

    }

    public String toJson() {
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            return ow.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
}
