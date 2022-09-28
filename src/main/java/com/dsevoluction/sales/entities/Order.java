package com.dsevoluction.sales.entities;

import com.dsevoluction.sales.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;
    private Double total;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "order")
    private List<ItemOrder> itemOrder = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Order() {

    }

    public Order(Integer id, Date date, Double total, Cliente cliente, OrderStatus status) {
        this.id = id;
        this.date = date;
        this.total = total;
        this.cliente = cliente;
        this.status = status;
    }

}