package com.pruebadeweb.JuanYanqui.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Constraint(validatedBy = RequeridoValidador.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface Requerido {
    String message() default "El costo no debe ser negativo";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
