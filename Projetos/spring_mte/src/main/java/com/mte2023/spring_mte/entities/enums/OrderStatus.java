/*package com.mte2023.spring_mte.entities.enums;

public enum Pedido_ColetaStatus {

    WAITING_PAYMENT(0),    /* no banco o status fica = 0
    PAID(1),               /* no banco o status fica = 1
    SHIPPED(2),            /* no banco o status fica = 2
    DELIVERED(3),          /* no banco o status fica = 3
    CANCELED(4);           /* no banco o status fica = 4

    private int code;

    private Pedido_ColetaStatus(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static Pedido_ColetaStatus valueOf(int code){
        for(Pedido_ColetaStatus value : Pedido_ColetaStatus.values()) {
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Pedido_ColetaStatus code");
    }
}

 */