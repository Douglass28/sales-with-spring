package com.dsevoluction.sales.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
    private Double price;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "order")
    private Set<ItemOrder> itemOrder = new HashSet<>();

    public Order() {

    }

    public Order(Integer id, Date date, Double price, Cliente cliente) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.cliente = cliente;
    }
}