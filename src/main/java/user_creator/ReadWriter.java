package user_creator;
import java.io.IOException;

public interface ReadWriter {

    void saveToFile(String filepath, Object obj) throws IOException;
    UserAccountList readFromFile(String filepath) throws IOException, ClassNotFoundException;

    }

