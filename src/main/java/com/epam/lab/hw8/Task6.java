package com.epam.lab.hw8;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class Task6 {
    public static void main(String[] args){
        Source xml = new StreamSource(new File("/Users/lni/IdeaProjects/hw8/src/main/java/com/epam/lab/hw8/candy.xml"));
        Source xslt = new StreamSource(new File("/Users/lni/IdeaProjects/hw8/src/main/java/com/epam/lab/hw8/candy.xsl"));
        convertXMLToHTML(xml, xslt);
    }

    public static void convertXMLToHTML(Source xml, Source xslt) {
        StringWriter sw = new StringWriter();
        try {

            FileWriter fw = new FileWriter("candy.html");
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transform = tFactory.newTransformer(xslt);
            transform.transform(xml, new StreamResult(sw));
            fw.write(sw.toString());
            fw.close();
        } catch (IOException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
