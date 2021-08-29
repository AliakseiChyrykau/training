package ru.mail.L_chr93;

import java.net.URL;
import java.text.ParseException;

import ru.mail.L_chr93.Logic.Reader.StaxReader;
import ru.mail.L_chr93.Logic.Reader.XMLReader;
import ru.mail.L_chr93.comparator.TypeComporator;
import ru.mail.L_chr93.domain.Concert;
import ru.mail.L_chr93.xml.validator.Validatable;
import ru.mail.L_chr93.xml.validator.ValidatorFactory;

public class Main {

    public static void main(String ...argsxStrings) throws ParseException {

        URL xmlUrl = Main.class.getResource("/Concert.xml");
        URL xsdUrl = Main.class.getResource("/Concert.xsd");

        ValidatorFactory vf = new ValidatorFactory();
        Validatable validator = vf.getXsdValidatorInstance();
        validator.isValid(xmlUrl, xsdUrl);
        
        XMLReader reader = new StaxReader();
        Concert concert = reader.readXMLFile(xmlUrl.getPath());
        
        concert.viewNumbers();
        System.out.println("-----------------------------------------------------------------------------------------");
        concert.sort(new TypeComporator());
        concert.viewNumbers();

    }
}
