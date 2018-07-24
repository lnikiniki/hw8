package com.epam.lab.hw8;

import com.epam.lab.hw8.candies.*;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Task8 {
    private static final Logger LOG = Logger.getLogger(Task8.class);

    private static void marshal() {
        Candy candy = new Candy();
        candy.setName("Test");
        candy.setType(Type.valueOf("CHOCOLATE"));
        candy.setEnergy(123.1);
        Ingredients ingredients = new Ingredients();
        ingredients.setChocolate(Chocolate.valueOf("MILK"));
        ingredients.setSugar(23.4);
        ingredients.setIngredient("cacao");
        candy.setIngredients(ingredients);
        Value value = new Value();
        value.setCarbohydrates(12.2);
        value.setFat(32.2);
        value.setProtein(16);
        candy.setValue(value);
        candy.setProduction("Test");
        try {
            File file = new File("marshal.xml");
            JAXBContext context = JAXBContext.newInstance(Candy.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(candy, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void unmarshal() {
        try {
            File file = new File("marshal.xml");
            JAXBContext context = JAXBContext.newInstance(Candy.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Candy candy = (Candy) unmarshaller.unmarshal(file);
            LOG.info(candy.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        marshal();
        unmarshal();
    }
}
