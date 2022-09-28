package com.dsevoluction.sales.entities.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum OrderStatus {

    WAITING_PAYMENT,
    PAID,
    SENT,
    DELIVERED,
    CANCELED;
}
