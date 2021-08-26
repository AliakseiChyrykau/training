package ru.mail.L_chr93.xml.validator;

import java.net.URL;

public interface Validatable {
    boolean isValid(URL urlXmlFile, URL urlSchema);
}
