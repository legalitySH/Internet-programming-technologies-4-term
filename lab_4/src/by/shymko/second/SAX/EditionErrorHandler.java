package by.shymko.second.SAX;

import org.apache.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class EditionErrorHandler implements ErrorHandler {

    private final Logger logger;
    public EditionErrorHandler(Logger logger)
    {
        this.logger = logger;
    }
    @Override
    public void warning(SAXParseException exception) throws SAXException {
        log("Warning", exception);
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        log("Error", exception);
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        log("Fatal error", exception);
    }

    private void log(String type, SAXParseException e)
    {
        logger.error(type + " line: " + e.getLineNumber() + " column: " + e.getColumnNumber() + " -" + e.getMessage());
    }

}
