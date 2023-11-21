package com.mte2023.spring_mte.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String phone;
    private String password;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Pedido_Coleta> Pedido_Coletas = new ArrayList<>();

    public User() {}

    public User(Long id, String nome, String email, String phone, String password, Address endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

<<<<<<< Updated upstream
    public Address getEndereco() {
        return endereco;
=======
    public Address getAddress() {
        return address;
>>>>>>> Stashed changes
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<CollectionOrder> getCollectionOrder() {
        return collectionOrdersList;
    }
<<<<<<< Updated upstream
=======

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
    //TODO: builder para collectionOrder
    public User build(){
        return user;
    }
}
>>>>>>> Stashed changes

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
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}