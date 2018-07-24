package com.epam.lab.hw8.Task4;

import com.epam.lab.hw8.candies.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXPars extends DefaultHandler {
    private Candies candies;
    private Candy candy;
    private Ingredients ingredients;
    private Value value;
    private boolean isName;
    private boolean isType;
    private boolean isEnergy;
    private boolean isSugar;
    private boolean isChocolate;
    private boolean isIngredient;
    private boolean isProtein;
    private boolean isFat;
    private boolean isCarb;
    private boolean isProduction;

    public Candies getCandies() {
        return candies;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("candies"))
            candies = new Candies();
        if (qName.equals("candy"))
            candy = new Candy();
        if (qName.equals("name"))
            isName = true;
        if (qName.equals("type"))
            isType = true;
        if (qName.equals("energy"))
            isEnergy = true;
        if (qName.equals("ingredients"))
            ingredients = new Ingredients();
        if (qName.equals("sugar"))
            isSugar = true;
        if (qName.equals("chocolate"))
            isChocolate = true;
        if (qName.equals("ingredient"))
            isIngredient = true;
        if (qName.equals("value"))
            value = new Value();
        if (qName.equals("protein"))
            isProtein = true;
        if (qName.equals("fat"))
            isFat = true;
        if (qName.equals("carbohydrates"))
            isCarb = true;
        if (qName.equals("production"))
            isProduction = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("candy"))
            candies.addCandies(candy);
        if (qName.equals("ingredients"))
            candy.setIngredients(ingredients);
        if (qName.equals("value"))
            candy.setValue(value);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String string = new String(ch, start, length);
        if (isName) {
            candy.setName(string);
            isName = false;
        }
        if (isType) {
            candy.setType(Type.valueOf(string.toUpperCase()));
            isType = false;
        }
        if (isEnergy) {
            candy.setEnergy(Double.parseDouble(string));
            isEnergy = false;
        }
        if (isSugar) {
            ingredients.setSugar(Double.parseDouble(string));
            isSugar = false;
        }
        if (isIngredient) {
            ingredients.setIngredient(string);
            isIngredient = false;
        }
        if (isChocolate) {
            ingredients.setChocolate(Chocolate.valueOf(string.toUpperCase()));
            isChocolate = false;
        }
        if (isProtein) {
            value.setProtein(Double.parseDouble(string));
            isProtein = false;
        }
        if (isFat) {
            value.setFat(Double.parseDouble(string));
            isFat = false;
        }
        if (isCarb) {
            value.setCarbohydrates(Double.parseDouble(string));
            isCarb = false;
        }
        if (isProduction) {
            candy.setProduction(string);
            isProduction = false;
        }
    }

    public static void main(String[] args) {
        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            SAXPars parser = new SAXPars();
            String url = "/Users/lni/IdeaProjects/hw8/src/main/java/com/epam/lab/hw8/candy.xml";
            saxParser.parse(url, parser);
            Candies candies = parser.getCandies();
            candies.showCandies();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
