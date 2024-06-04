package by.shymko.second.shopexception;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;


public class EditionFindException extends Exception{
    public EditionFindException(String message, Logger logger) throws IOException {
        super(message);
        logger.error(message);
    }
}
