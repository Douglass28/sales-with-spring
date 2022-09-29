package com.dsevoluction.sales.entities.dtos;

import com.dsevoluction.sales.entities.enums.OrderStatus;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

/*
{
    "Cliente": "1",
    "total" : 100.0,
    "status": "DELIVERED"
    "items":[
        {
            "produto": 1,
            "quantidade": 10
        }
    ]
}
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Integer cliente;
    private Double total;
    private OrderStatus status;
    private List<ItemOrderDTO> items;
}
