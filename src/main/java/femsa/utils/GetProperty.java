package femsa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperty {
    public static String fromPropertyFile(String propertyName){
        try(InputStream inputStream = new FileInputStream("src/test/resources/properties/usuario.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties.getProperty(propertyName);

        } catch (FileNotFoundException e) {
            System.out.println("Property " + propertyName + " doesn't exist");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(fromPropertyFile("linea"));
    }
}
