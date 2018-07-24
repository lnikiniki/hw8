package com.epam.lab.hw8.candies;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ingredients", propOrder = {"sugar", "chocolate", "ingredient"})
public class Ingredients {
    @XmlElement(required = true)
    private double sugar;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    private Chocolate chocolate;
    @XmlElement(required = true)
    private String ingredient;

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public Chocolate getChocolate() {
        return chocolate;
    }

    public void setChocolate(Chocolate chocolate) {
        this.chocolate = chocolate;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public String toString() {
        return String.format("\tsugar: %s\n\tchocolate: %s\n\tingredient: %s", this.sugar, this.chocolate, this.ingredient);
    }
}
