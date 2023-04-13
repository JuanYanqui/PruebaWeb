package com.pruebadeweb.JuanYanqui.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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


    @Size(min = 10, max = 10)
    @Pattern(regexp = "^[0-9]+$", message = "El campo debe contener solo números")
    @NotEmpty(message = "El codigo no debe estar vacio par su ingreso.")
    @Column(name="cedula")
    private String cedula;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]+$", message = "El campo debe contener solo letras")
    @NotEmpty
    @Column(name="nombre")
    private String nombre;
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z]+$", message = "El campo debe contener solo letras")
    @Column(name="apellido")
    private String apellido;
    @NotEmpty
    @Pattern(regexp = "^[0-9]+$", message = "El campo debe contener solo números")
    @Size(min = 10, max = 10)
    @Column(name="celular")
    private String celular;
    @NotEmpty
    @Column(name="direccion")
    private String direccion;

    @JsonIgnore
    @OneToMany (mappedBy = "cliente")
    private List<Ventas> ventas;

}
