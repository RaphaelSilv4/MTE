package com.mte2023.spring_mte.entities;

import java.io.Serializable;

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
    protected Integer userid;
    @OneToOne
    @PrimaryKeyJoinColumn(name="user_id", referencedColumnName = "id")
    protected User owner;

}