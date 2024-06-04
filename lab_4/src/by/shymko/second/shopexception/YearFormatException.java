package by.shymko.second.shopexception;


import java.io.IOException;
import org.apache.log4j.Logger;

public class YearFormatException extends Exception {
    public YearFormatException(String message,Logger logger) throws IOException {
        super(message);
        logger.error(message);
    }
}
