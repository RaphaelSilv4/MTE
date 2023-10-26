package com.mte2023.spring_mte.entities;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mte2023.spring_mte.entities.enums.Pedido_ColetaStatus;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido_coleta")
public class Pedido_Coleta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    private Integer pedido_ColetaStatus; /* Tratamento Integer é interno a classe Pedido_Coleta */

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "pedido_Coleta", cascade = CascadeType.ALL) /* No caso de 1 para 1 as duas entidades possuem o mesmo ID */
    private Payment payment;
    
    public Pedido_Coleta(){}

    public Pedido_Coleta(Long id, Instant moment, Pedido_ColetaStatus pedido_ColetaStatus, User user) {
        this.id = id;
        this.moment = moment;
        setPedido_ColetaStatus(pedido_ColetaStatus);
        this.user = user;
    }

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

    public Pedido_ColetaStatus getPedido_ColetaStatus() {
        return Pedido_ColetaStatus.valueOf(pedido_ColetaStatus);
    }

    public void setPedido_ColetaStatus(Pedido_ColetaStatus pedido_ColetaStatus) {
        if(pedido_ColetaStatus != null){
            this.pedido_ColetaStatus = pedido_ColetaStatus.getCode();
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
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
        Pedido_Coleta other = (Pedido_Coleta) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}