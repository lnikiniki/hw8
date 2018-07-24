package com.epam.lab.hw8.candies;

import org.apache.log4j.Logger;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "candies", propOrder = "candies")
public class Candies {
    private static final Logger LOG = Logger.getLogger(Candies.class);
    @XmlElement(required = true)
    protected List<Candy> candies;

    public List<Candy> getCandies() {
        if (candies == null)
            candies = new ArrayList<Candy>();
        return candies;
    }

    public void addCandies(Candy candy) {
        if (candies == null)
            candies = new ArrayList<Candy>();
        candies.add(candy);
    }

    public void showCandies() {
        for (Candy candy : candies) {
            LOG.info(candy.toString());
        }
    }
}
