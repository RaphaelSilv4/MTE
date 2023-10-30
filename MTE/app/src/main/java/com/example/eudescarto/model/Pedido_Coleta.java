package com.example.eudescarto.model;

import com.example.eudescarto.model.enums.Pedido_ColetaStatus;

import java.io.Serializable;
import java.time.Instant;






public class Pedido_Coleta implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;


    private Instant moment;

    private Integer pedido_ColetaStatus; /* Tratamento Integer e interno a classe Pedido_Coleta */


    private User user;


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