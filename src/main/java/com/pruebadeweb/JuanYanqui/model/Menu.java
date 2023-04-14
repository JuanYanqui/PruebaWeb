package com.pruebadeweb.JuanYanqui.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pruebadeweb.JuanYanqui.validation.Requerido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="menus")
public class Menu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idMenu")
    private Long idMenu;
    @NotEmpty
    @Size(min = 3, max = 4)
    @Pattern(regexp = "^[0-9]+$", message = "El campo debe contener solo números")
    @Column(name="codigoMenu")
    private String codigoMenu;


    @NotEmpty
    @Column(name="descripcion")
    private String descripcion;
    @Requerido
    @Column(name="costo")
    private Double costo;


    @JsonIgnore
    @OneToMany (mappedBy = "menu")
    private List<Ventas> ventas;
}
