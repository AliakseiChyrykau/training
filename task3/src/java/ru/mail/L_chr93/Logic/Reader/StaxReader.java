package ru.mail.L_chr93.Logic.Reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import ru.mail.L_chr93.domain.*;

public class StaxReader implements XMLReader {

    @Override
    public Concert readXMLFile(String xmlFilePath) {
        Concert concert = new Concert();

        XMLInputFactory factory = XMLInputFactory.newInstance();

        try {
            XMLEventReader xmlReader = factory.createXMLEventReader(new FileInputStream(xmlFilePath));
            while (xmlReader.hasNext()) {
                XMLEvent event = xmlReader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();

                    if (startElement.getName().getLocalPart().equals("dance_number")) {
                        concert.addNumber(readDanceNumber(xmlReader, startElement));
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }

        return concert;
    }

    private DanceNumber readDanceNumber(XMLEventReader xmlReader, StartElement startElement) {
        DanceNumber danceNumber = new DanceNumber();
        Attribute idAttr = startElement.getAttributeByName(new QName("orderid"));
        if (idAttr != null) {
            danceNumber.setId(idAttr.getValue());
        }

        try {
            while (xmlReader.hasNext()) {
                XMLEvent event = xmlReader.nextEvent();
                if (event.isStartElement()) {
                    StartElement se = event.asStartElement();

                    switch (se.getName().getLocalPart()) {
                    case "type": {
                        event = xmlReader.nextEvent();
                        danceNumber.setType(Type.valueOf(event.asCharacters().getData()));
                        break;
                    }

                    case "scene": {
                        event = xmlReader.nextEvent();
                        danceNumber.setScene(Scene.valueOf(event.asCharacters().getData()));
                        break;
                    }
                    case "number_of_dancers": {
                        event = xmlReader.nextEvent();
                        danceNumber.setNumberOfDancers(NumberOfDancers.valueOf(event.asCharacters().getData()));
                        break;
                    }
                    case "music": {
                        event = xmlReader.nextEvent();
                        danceNumber.setMusic(Music.valueOf(event.asCharacters().getData()));
                        break;
                    }

                    case "dancers": {
                        danceNumber.setListDancer(readListDancers(xmlReader));
                        break;
                    }
                    case "number": {
                        event = xmlReader.nextEvent();
                        danceNumber.setNumber(Integer.parseInt(event.asCharacters().getData()));
                        break;
                    }
                    default:
                        break;
                    }
                }

                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals("dance_number")) {
                        return danceNumber;
                    }
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return danceNumber;
    }

    private List<Dancers> readListDancers(XMLEventReader xmlReader) {
        List<Dancers> dancersList = new ArrayList<>();
        Dancer dancer;
        DanceGroup danceGroup;

        try {
            while (xmlReader.hasNext()) {
                XMLEvent event = xmlReader.nextEvent();
                if (event.isStartElement()) {
                    StartElement se = event.asStartElement();

                    switch (se.getName().getLocalPart()) {
                    case "dancer": {
                        event = xmlReader.nextEvent();
                        dancer = readDancer(xmlReader);
                        dancersList.add(dancer);
                        break;
                    }

                    case "dancegroup": {
                        event = xmlReader.nextEvent();
                        danceGroup = readDanceGroup(xmlReader);
                        dancersList.add(danceGroup);
                        break;
                    }
                    default:
                        break;
                    }
                }

                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals("dancers")) {
                        return dancersList;
                    }
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return dancersList;
    }

    private Dancer readDancer(XMLEventReader xmlReader) {
        Dancer dancer = new Dancer();

        try {
            while (xmlReader.hasNext()) {
                XMLEvent event = xmlReader.nextEvent();
                if (event.isStartElement()) {
                    StartElement se = event.asStartElement();

                    switch (se.getName().getLocalPart()) {
                    case "name": {
                        event = xmlReader.nextEvent();
                        String name = event.asCharacters().getData();
                        dancer.setName(name);
                        break;
                    }

                    case "age": {
                        event = xmlReader.nextEvent();
                        dancer.setAge(Integer.parseInt(event.asCharacters().getData()));
                        break;
                    }

                    case "how_many_years": {
                        event = xmlReader.nextEvent();
                        dancer.setHow_many_years(Integer.parseInt(event.asCharacters().getData()));
                        break;
                    }
                    default:
                        break;
                    }
                }

                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals("dancer")) {
                        return dancer;
                    }
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return dancer;
    }

    private DanceGroup readDanceGroup(XMLEventReader xmlReader) {
        DanceGroup danceGroup = new DanceGroup();

        try {
            while (xmlReader.hasNext()) {
                XMLEvent event = xmlReader.nextEvent();
                if (event.isStartElement()) {
                    StartElement se = event.asStartElement();
                    switch (se.getName().getLocalPart()) {
                    case "name": {
                        event = xmlReader.nextEvent();
                        String name = event.asCharacters().getData();
                        danceGroup.setName(name);
                        break;
                    }

                    case "name_head": {
                        event = xmlReader.nextEvent();
                        danceGroup.setName_head(event.asCharacters().getData());
                        break;
                    }

                    case "year_formation": {
                        event = xmlReader.nextEvent();
                        SimpleDateFormat fd = new SimpleDateFormat("yyyy-mm-dd");
                        Date year_formation = fd.parse(event.asCharacters().getData());
                        danceGroup.setYear_formation(year_formation);
                        break;
                    }
                    default:
                        break;
                    }
                }

                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals("dancegroup")) {
                        return danceGroup;
                    }
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return danceGroup;
    }
}
