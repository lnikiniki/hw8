package com.epam.lab.hw8.candies;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "type")
@XmlEnum
public enum Type {
    @XmlEnumValue("chocolate")
    CHOCOLATE("chocolate"),
    @XmlEnumValue("caramel")
    CARAMEL("caramel"),
    @XmlEnumValue("waffle")
    WAFFLE("waffle"),
    @XmlEnumValue("jelly")
    JELLY("jelly");
    private final String value;

    Type(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Type fromValue(String v) {
        for (Type c : Type.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
