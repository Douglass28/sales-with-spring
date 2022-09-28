package com.dsevoluction.sales.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "o nome deve ser informado")
    private String name;

    @NotEmpty(message = "o cpf deve ser informado")
    @CPF(message = "o CPF deve ser valido")
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<Order> orders = new HashSet<>();

    public Cliente(){
    }

    public Cliente(Integer id, String name, String cpf){
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    }
}