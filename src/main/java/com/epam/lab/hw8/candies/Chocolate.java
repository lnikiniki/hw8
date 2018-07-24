package com.epam.lab.hw8.candies;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "chocolate")
@XmlEnum
public enum Chocolate {
    @XmlEnumValue("milk")
    MILK("milk"),
    @XmlEnumValue("dark")
    DARK("dark"),
    @XmlEnumValue("white")
    WHITE("white"),
    @XmlEnumValue("no")
    NO("no");
    private final String value;

    Chocolate(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Chocolate fromValue(String v) {
        for (Chocolate c : Chocolate.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
