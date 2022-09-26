package com.dsevoluction.sales.entities.dtos;

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

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ItemOrderDTO {

    private Integer produto;
    private Integer quantity;
}
