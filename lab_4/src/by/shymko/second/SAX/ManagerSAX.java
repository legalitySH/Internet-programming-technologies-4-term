package by.shymko.second.SAX;

import by.shymko.second.products.Book;
import org.apache.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManagerSAX {
    private final String filename;
    private final String schemaFileName;
    private final Logger logger;

    public ManagerSAX(String filename , String schemaFileName, Logger logger)
    {
        this.filename = filename;
        this.schemaFileName = schemaFileName;
        this.logger = logger;
    }




    public void validSchema()
    {
         Schema schema;

        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;

        SchemaFactory factory = SchemaFactory.newInstance(language);

        try {
            schema = factory.newSchema(new File(schemaFileName));
            Validator validator = schema.newValidator();
            Source source = new StreamSource(filename);
            EditionErrorHandler editionHandler = new EditionErrorHandler(logger);
            validator.setErrorHandler(editionHandler);
            validator.validate(source);
            System.out.println("[VALIDATOR] - success " + filename + " validate");
        } catch (SAXException | IOException e) {
            throw new RuntimeException(e);


        }


    }

    public List<Book> parseBooks(String xmlDoc) throws ParserConfigurationException, SAXException, IOException {
        List<Book> bookList = new ArrayList<>();

        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        Source source = new StreamSource(filename);
        EditionErrorHandler editionErrorHandler = new EditionErrorHandler(logger);
        EditionHandler editionHandler = new EditionHandler(logger, bookList, editionErrorHandler);
        SAXParserFactory SAXfactory = SAXParserFactory.newInstance();
        SAXParser parser = SAXfactory.newSAXParser();
        parser.parse(xmlDoc, editionHandler);




        try {
            Schema schema = factory.newSchema(new File(schemaFileName));
            Validator validator = schema.newValidator();
            validator.setErrorHandler(editionHandler);
            validator.validate(source);
        } catch (SAXException | IOException e) {
            throw new RuntimeException(e);
        }

        return bookList;
    }






}
