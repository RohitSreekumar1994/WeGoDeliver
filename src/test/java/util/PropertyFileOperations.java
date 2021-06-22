package util;

import java.io.FileReader;
import java.util.Properties;

/**
 * PropertyFile operations class contains methods to get data from the "env.properties" file
 * present under "srd/main/resources/
 */
public class PropertyFileOperations {


    private FileReader reader;
    private Properties properties = new Properties();
    private String path;

    public PropertyFileOperations() {
        try {
            String folderSep = System.getProperty("file.separator");
            path = System.getProperty("user.dir") + folderSep + "src" + folderSep + "main" + folderSep + "resources" + folderSep + "env.properties";
            reader = new FileReader(path);
            properties.load(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to read a particular property
     * @param propertyName - The name of the property to be read
     * @return - the propery value, if present in "env.properties" file, or else returns null
     */
    public String getProperty(String propertyName) {

        String propertyValue;

        try {
            propertyValue = (String) properties.get(propertyName);
            return propertyValue;
        } catch (Exception e) {
            return null;
        }

    }
}
