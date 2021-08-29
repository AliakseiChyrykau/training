package ru.mail.L_chr93.Logic.Reader;

import ru.mail.L_chr93.domain.Concert;

public interface XMLReader {
    Concert readXMLFile(String xmlFilePath);
}
