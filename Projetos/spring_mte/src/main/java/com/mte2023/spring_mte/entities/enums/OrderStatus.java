package com.mte2023.spring_mte.entities.enums;

public enum OrderStatus {

    WAITING_PAYMENT(0),    // no banco o status fica = 0
    PAID(1),               // no banco o status fica = 1
    SHIPPED(2),            // no banco o status fica = 2
    DELIVERED(3),          // no banco o status fica = 3
    CANCELED(4);           // no banco o status fica = 4

    private int code;

    private OrderStatus(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static OrderStatus valueOf(int code){
        for(OrderStatus value : OrderStatus.values()) {
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Pedido_ColetaStatus code");
    }
}

