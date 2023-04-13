package com.pruebadeweb.JuanYanqui.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.cfg.context.Constrainable;

public class RequeridoValidador implements ConstraintValidator<Requerido, Double >{
//    @Override
//    public boolean isValid(String value, ConstraintValidatorContext context) {
//        if(value == null || value.isEmpty() || value.isBlank()){
//            return false;
//        }
//        return true;
//    }
        @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        if(value == null || Double.parseDouble(String.valueOf(value))< 0){
            return false;
        }
        return true;
    }
}
