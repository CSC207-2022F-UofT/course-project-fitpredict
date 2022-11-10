package user_creator;

import java.io.*;

public class UserReadWriter implements ReadWriter {

    /**
     * Writes the users to file at filePath.
     */

    @Override
    public void saveToFile(String filepath, Object users) throws IOException {
        OutputStream file = new FileOutputStream(filepath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // Serializing the map
        output.writeObject(users);
        output.close();

    }

    @Override
    public UserAccountList readFromFile(String filepath) throws IOException, ClassNotFoundException {
        InputStream file = new FileInputStream(filepath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        // Serializing the map with the inputs
        UserAccountList users = (UserAccountList) input.readObject();
        input.close();
        return users;

    }

}
