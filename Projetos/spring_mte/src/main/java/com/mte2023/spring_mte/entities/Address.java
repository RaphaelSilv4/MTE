package com.mte2023.spring_mte.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "tb_address")
public class Address implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int cep;
    private int numero_casa;
    private String nome_rua;
    private String nome_bairro;
    private String cidade;
    private String estado_federativo;

    @JsonIgnore
    @OneToMany(mappedBy = "endereco")
    private List<User> users = new ArrayList<>();

    public Address() {}

    public Address(Long id, int cep, int numero_casa, String nome_rua, String nome_bairro, String cidade,
            String estado_federativo) {
        this.id = id;
        this.cep = cep;
        this.numero_casa = numero_casa;
        this.nome_rua = nome_rua;
        this.nome_bairro = nome_bairro;
        this.cidade = cidade;
        this.estado_federativo = estado_federativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getNumero_casa() {
        return numero_casa;
    }

    public void setNumero_casa(int numero_casa) {
        this.numero_casa = numero_casa;
    }

    public String getNome_rua() {
        return nome_rua;
    }

    public void setNome_rua(String nome_rua) {
        this.nome_rua = nome_rua;
    }

    public String getNome_bairro() {
        return nome_bairro;
    }

    public void setNome_bairro(String nome_bairro) {
        this.nome_bairro = nome_bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado_federativo() {
        return estado_federativo;
    }

    public void setEstado_federativo(String estado_federativo) {
        this.estado_federativo = estado_federativo;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}