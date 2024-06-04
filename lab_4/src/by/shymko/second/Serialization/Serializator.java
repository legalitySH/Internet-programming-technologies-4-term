package by.shymko.second.Serialization;

import by.shymko.second.products.Book;
import org.apache.log4j.Logger;

import java.io.*;

public class Serializator {

    private final Logger logger;
    public Serializator(Logger logger)
    {

        this.logger = logger;
    }
    public  void serializeObject(Object obj, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(obj);
            logger.debug("Object serialized to file" + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public deserializeObject(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            Book book = (Book) inputStream.readObject();
            logger.debug("Object serialized to file" + fileName);
            return book;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}


