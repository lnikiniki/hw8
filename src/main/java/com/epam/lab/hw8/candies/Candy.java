package com.epam.lab.hw8.candies;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "candy", propOrder = {"name", "type", "energy", "ingredients", "value", "production"})
public class Candy {
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    Type type;
    @XmlElement(required = true)
    double energy;
    @XmlElement(required = true)
    Ingredients ingredients;
    @XmlElement(required = true)
    Value value;
    @XmlElement(required = true)
    String production;
    @XmlElement(required = true)
    String name;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nType: %s\nEnergy: %s\nIngredients:\n%s\nValue:\n%s\nProduction: %s\n", this.name, this.type, this.energy, this.ingredients.toString(), this.value.toString(), this.production);
    }
}
