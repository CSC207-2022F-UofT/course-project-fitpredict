package user_login;

import java.io.IOException;

public interface ReadWriter {

    /**
     * An interface that is implemented by UserReadWriter
     * @param filepath The filepath
     * @param obj The object
     * @throws IOException Throws exception
     */
    void saveToFile(String filepath, Object obj) throws IOException;
    UserAccountList readFromFile(String filepath) throws IOException, ClassNotFoundException;

}


