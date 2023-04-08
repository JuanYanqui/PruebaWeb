package com.pruebadeweb.JuanYanqui.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="ventas")
public class Ventas implements  Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idVenta")
    private Long idVenta;

    @Column(name="cantidad")
    private Integer cantidad;

    @Column(name="fecha")
    private LocalDate fecha;

    @Column(name="costo_menu")
    private Integer costo_menu;

    @Column(name="total")
    private Integer total;
    @ManyToOne
    @JoinColumn(name="idCliente",referencedColumnName ="idCliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="idMenu",referencedColumnName ="idMenu")
    private Menu menu;
}
