package by.shymko.second.SAX;

import by.shymko.second.products.Genre;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import by.shymko.second.products.Book;

import java.util.List;

public class EditionHandler extends DefaultHandler {
    private final List<Book> bookList;
    private Book currentBook;
    private final StringBuilder content;
    private final EditionErrorHandler errorHandler;

    private  final Logger logger;

    public EditionHandler(Logger logger, List<Book> bookList, EditionErrorHandler errorHandler ) {
        this.bookList = bookList;
        this.errorHandler = errorHandler;
        this.logger = logger;
        content = new StringBuilder();
        currentBook = new Book();
    }

    public void addBook() {
        if (currentBook != null) {
            bookList.add(currentBook);
            currentBook = new Book();
        }
    }

    @Override
    public void startDocument() {
        logger.debug("START PARSING");
    }

    @Override
    public void endDocument()
    {
        logger.debug("END PARSING");
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content.setLength(0);
        content.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("title".equals(qName)) {
            currentBook.setTitle(content.toString());
        } else if ("price".equalsIgnoreCase(qName)) {
            try {
                currentBook.setPrice(Double.parseDouble(content.toString().trim()));
            } catch (NumberFormatException e) {
                errorHandler.error(new SAXParseException("Invalid price format", null, e));
            }
        } else if ("genre".equalsIgnoreCase(qName)) {
            String genreValue = content.toString().trim();
            try {
                Genre genre = Genre.valueOf(genreValue);
                currentBook.setGenre(genre);
            } catch (IllegalArgumentException e) {
                errorHandler.error(new SAXParseException("Invalid genre: " + genreValue, null, e));
            }
        } else if ("publishingYear".equalsIgnoreCase(qName)) {
            try {
                currentBook.setPublishingYear(Integer.parseInt(content.toString().trim()));
            } catch (NumberFormatException e) {
                errorHandler.error(new SAXParseException("Invalid publishing year format", null, e));
            }
        } else if ("author".equalsIgnoreCase(qName)) {
            currentBook.setAuthor(content.toString().trim());
        } else if ("countOfPages".equalsIgnoreCase(qName)) {
            try {
                currentBook.setCountOfPages(Integer.parseInt(content.toString().trim()));
            } catch (NumberFormatException e) {
                errorHandler.error(new SAXParseException("Invalid count of pages format", null, e));
            }
        } else if ("book".equalsIgnoreCase(qName)) {
            addBook();
        }
    }
}
