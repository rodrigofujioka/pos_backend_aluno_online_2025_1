package br.com.alunoonline.api.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class IespEmailValidator implements ConstraintValidator<ApenasIespEmail, String> {

    @Override
    public boolean isValid(String valor, ConstraintValidatorContext context) {
        if (valor.contains("@iesp.com.br")){
            return true; // @NotNull deve ser usado separadamente se necessário
        }
        return false;
    }
}
