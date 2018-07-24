package com.epam.lab.hw8.Task4;

import com.epam.lab.hw8.candies.*;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;

public class StAXPars {
    private Candies candies;
    private Candy candy;
    private Ingredients ingredients;
    private Value value;

    void startElement(XMLEvent event, XMLEventReader reader) throws XMLStreamException {
        StartElement startElement = event.asStartElement();
        if (startElement.getName().getLocalPart().equals("candies"))
            candies = new Candies();
        if (startElement.getName().getLocalPart().equals("candy"))
            candy = new Candy();
        if (startElement.getName().getLocalPart().equals("name")) {
            event = reader.nextEvent();
            candy.setName(event.asCharacters().getData());
        }
        if (startElement.getName().getLocalPart().equals("type")) {
            event = reader.nextEvent();
            candy.setType(Type.valueOf(event.asCharacters().getData().toUpperCase()));
        }
        if (startElement.getName().getLocalPart().equals("energy")) {
            event = reader.nextEvent();
            candy.setEnergy(Double.parseDouble(event.asCharacters().getData()));
        }
        if (startElement.getName().getLocalPart().equals("ingredients"))
            ingredients = new Ingredients();
        if (startElement.getName().getLocalPart().equals("sugar")) {
            event = reader.nextEvent();
            ingredients.setSugar(Double.parseDouble(event.asCharacters().getData()));
        }
        if (startElement.getName().getLocalPart().equals("chocolate")) {
            event = reader.nextEvent();
            ingredients.setChocolate(Chocolate.valueOf(event.asCharacters().getData().toUpperCase()));
        }
        if (startElement.getName().getLocalPart().equals("ingredient")) {
            event = reader.nextEvent();
            ingredients.setIngredient(event.asCharacters().getData());
        }
        if (startElement.getName().getLocalPart().equals("value"))
            value = new Value();
        if (startElement.getName().getLocalPart().equals("protein")) {
            event = reader.nextEvent();
            value.setProtein(Double.parseDouble(event.asCharacters().getData()));
        }
        if (startElement.getName().getLocalPart().equals("fat")) {
            event = reader.nextEvent();
            value.setFat(Double.parseDouble(event.asCharacters().getData()));
        }
        if (startElement.getName().getLocalPart().equals("carbohydrates")) {
            event = reader.nextEvent();
            value.setCarbohydrates(Double.parseDouble(event.asCharacters().getData()));
        }
        if (startElement.getName().getLocalPart().equals("production")) {
            event = reader.nextEvent();
            candy.setProduction(event.asCharacters().getData());
        }
    }

    void endElement(XMLEvent event, XMLEventReader reader) throws XMLStreamException {
        EndElement endElement = event.asEndElement();
        if (endElement.getName().getLocalPart().equals("candy")) {
            candies.addCandies(candy);
        }
        if (endElement.getName().getLocalPart().equals("ingredients")) {
            candy.setIngredients(ingredients);
        }
        if (endElement.getName().getLocalPart().equals("value")) {
            candy.setValue(value);
        }
    }

    Candies getCandies() {
        return candies;
    }

    public static void main(String[] args) {
        String url = "/Users/lni/IdeaProjects/hw8/src/main/java/com/epam/lab/hw8/candy.xml";
        StAXPars stAXPars = new StAXPars();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = factory.createXMLEventReader(new FileInputStream(url));
            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                if (event.isStartElement())
                    stAXPars.startElement(event, reader);
                if (event.isEndElement())
                    stAXPars.endElement(event, reader);
            }
            Candies candies = stAXPars.getCandies();
            candies.showCandies();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}