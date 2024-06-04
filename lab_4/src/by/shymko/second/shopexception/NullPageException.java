package by.shymko.second.shopexception;


import java.io.IOException;
import org.apache.log4j.Logger;

public class NullPageException extends Exception {
    public NullPageException(String message,Logger logger) throws IOException {
        super(message);
        logger.error(message);
    }
}
