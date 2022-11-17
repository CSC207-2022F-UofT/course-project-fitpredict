package user_login;

import java.io.IOException;

public class UserReadWriter implements ReadWriter{

    /**
     * Writes the users to file at filePath.
     * @param filepath The filepath
     * @param users The users
     * @throws IOException Throws exception
     */
    @Override
    public void saveToFile(String filepath, Object users) throws IOException {

    }

    /**
     * Reads the users from the file at filepath
     * @param filepath The filepath
     * @return the users in the filepath
     * @throws IOException Throws exception
     * @throws ClassNotFoundException Throws class not found exception
     */

    public UserAccountList readFromFile(String filepath) throws IOException, ClassNotFoundException {
        return users;
    }

}
