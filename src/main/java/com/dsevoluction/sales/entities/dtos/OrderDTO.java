package com.dsevoluction.sales.entities.dtos;

import lombok.*;

import java.util.List;
import java.util.Set;

/*
{
    "Cliente": "1",
    "total" : 100.0,
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
    private List<ItemOrderDTO> items;
}
