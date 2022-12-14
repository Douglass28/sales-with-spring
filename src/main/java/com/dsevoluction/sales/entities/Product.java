package com.dsevoluction.sales.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "está faltando descrição do produto")
    private String description;
    @NotNull(message = "está faltando o preço do produto")
    private Double price;

    public Product() {

    }
    public Product(Integer id, String description, Double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }
}