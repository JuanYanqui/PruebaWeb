package com.pruebadeweb.JuanYanqui.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="clientes")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCliente")
    private Long idCliente;

    @NotEmpty
    @Column(name="cedula")
    private String cedula;
    @NotEmpty
    @Column(name="nombre")
    private String nombre;
    @NotEmpty
    @Column(name="apellido")
    private String apellido;
    @NotEmpty
    @Column(name="celular")
    private String celular;
    @NotEmpty
    @Column(name="direccion")
    private String direccion;

    @JsonIgnore
    @OneToMany (mappedBy = "cliente")
    private List<Ventas> ventas;

}
