package com.epam.lab.hw8;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class Task5 {
    private static final Logger LOG = Logger.getLogger(Task5.class);

    public static void main(String[] args) {
        File schemaFile = new File("/Users/lni/IdeaProjects/hw8/src/main/java/com/epam/lab/hw8/candy.xsd");
        Source xmlFile = new StreamSource(new File("/Users/lni/IdeaProjects/hw8/src/main/java/com/epam/lab/hw8/candy.xml"));
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
            LOG.info(xmlFile.getSystemId() + " is valid");
        } catch (SAXException e) {
            LOG.info(xmlFile.getSystemId() + " is NOT valid");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
