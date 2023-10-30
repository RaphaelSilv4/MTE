package com.example.eudescarto.model;

import java.io.Serializable;
import java.time.Instant;



public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;


    private Instant moment;


    private Pedido_Coleta pedido_Coleta;

    public Payment(){}

    public Payment(Long id, Instant moment, Pedido_Coleta pedido_Coleta) {
        super();
        this.id = id;
        this.moment = moment;
        this.pedido_Coleta = pedido_Coleta;
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

    public Pedido_Coleta getPedido_Coleta() {
        return pedido_Coleta;
    }

    public void setPedido_Coleta(Pedido_Coleta pedido_Coleta) {
        this.pedido_Coleta = pedido_Coleta;
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
        Payment other = (Payment) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
