package femsa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class GetProperty {
    private GetProperty() {
    }

    private static final Logger LOGGER = Logger.getLogger(GetProperty.class.getName());
    public static String fromPropertyFile(String file, String propertyName) throws RuntimeException {
        try(InputStream inputStream = new FileInputStream(file)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties.getProperty(propertyName);

        } catch (FileNotFoundException e) {
            LOGGER.warning("Property " + propertyName + " doesn't exist");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
