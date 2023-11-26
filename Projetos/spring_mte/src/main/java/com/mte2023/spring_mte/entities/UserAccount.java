package com.mte2023.spring_mte.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "user_account")
public class UserAccount implements Serializable{

    @Id
    @Column(name="user_id")
    protected Integer userid;
    @OneToOne
    @PrimaryKeyJoinColumn(name="user_id", referencedColumnName = "id")
    protected User owner;

}