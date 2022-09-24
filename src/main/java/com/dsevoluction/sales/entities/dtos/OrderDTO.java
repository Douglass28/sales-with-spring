package com.dsevoluction.sales.entities.dtos;

import java.util.List;


public class OrderDTO {

    private Integer cliente;
    private Double total;
    private List<ItemOrderDTO> items;
}
