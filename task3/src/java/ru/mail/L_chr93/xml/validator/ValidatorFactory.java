package ru.mail.L_chr93.xml.validator;

public class ValidatorFactory {

    public Validatable getXsdValidatorInstance() {
        return new XsdValidator();
    }
}
