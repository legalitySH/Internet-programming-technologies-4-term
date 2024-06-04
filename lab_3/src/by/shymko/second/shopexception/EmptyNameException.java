package by.shymko.second.shopexception;

import java.io.IOException;
import org.apache.log4j.Logger;

public class EmptyNameException extends Exception{
    public EmptyNameException(String message,Logger logger) throws IOException {
        super(message);
        logger.error(message);
    }
}
