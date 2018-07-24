package com.epam.lab.hw8.candies;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "value", propOrder = {"protein", "fat", "carbohydrates"})
public class Value {
    @XmlElement(required = true)
    private double protein;
    @XmlElement(required = true)
    private double fat;
    @XmlElement(required = true)
    private double carbohydrates;

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    @Override
    public String toString() {
        return String.format("\tprotein: %s\n\tfat: %s\n\tcarbohydrates: %s", this.protein, this.fat, this.carbohydrates);
    }
}
