package com.epam.lab.hw8.Task4;

import com.epam.lab.hw8.candies.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMPars {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        String url = "/Users/lni/IdeaProjects/hw8/src/main/java/com/epam/lab/hw8/candy.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(url));
        Candies candies = new Candies();
        NodeList candiesList = document.getDocumentElement().getElementsByTagName("candy");
        NodeList ingredientList = document.getDocumentElement().getElementsByTagName("ingredients");
        NodeList valueList = document.getDocumentElement().getElementsByTagName("value");
        findCandy(candiesList, ingredientList, valueList, candies);
        candies.showCandies();
    }

    static void findCandy(NodeList nodeList, NodeList ingredientList, NodeList valueList, Candies candies) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Candy candy = new Candy();
            Node node = nodeList.item(i);
            Element element = (Element) node;
            candy.setName(element.getElementsByTagName("name").item(0).getTextContent());
            candy.setType(Type.valueOf(element.getElementsByTagName("type").item(0).getTextContent().toUpperCase()));
            candy.setEnergy(Double.parseDouble(element.getElementsByTagName("energy").item(0).getTextContent()));
            candy.setIngredients(findIngredient(ingredientList, i));
            candy.setValue(findValue(valueList, i));
            candy.setProduction(element.getElementsByTagName("production").item(0).getTextContent());
            candies.addCandies(candy);
        }
    }

    static Ingredients findIngredient(NodeList nodeList, int i) {
        Ingredients ingredients = new Ingredients();
        Node node = nodeList.item(i);
        Element element = (Element) node;
        ingredients.setSugar(Double.parseDouble(element.getElementsByTagName("sugar").item(0).getTextContent()));
        ingredients.setChocolate(Chocolate.valueOf(element.getElementsByTagName("chocolate").item(0).getTextContent().toUpperCase()));
        ingredients.setIngredient(element.getElementsByTagName("sugar").item(0).getTextContent());
        return ingredients;
    }

    static Value findValue(NodeList nodeList, int i) {
        Value value = new Value();
        Node node = nodeList.item(i);
        Element element = (Element) node;
        value.setProtein(Double.parseDouble(element.getElementsByTagName("protein").item(0).getTextContent()));
        value.setFat(Double.parseDouble(element.getElementsByTagName("fat").item(0).getTextContent()));
        value.setCarbohydrates(Double.parseDouble(element.getElementsByTagName("carbohydrates").item(0).getTextContent()));
        return value;
    }
}
