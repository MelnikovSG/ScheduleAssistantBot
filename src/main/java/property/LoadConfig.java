package property;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadConfig {

    public String loadConfig(String key){
        Properties props = new Properties();
        try (InputStream in = new FileInputStream("src/main/resources/properties/config.properties.txt")) {
            props.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return props.getProperty(key);
    }
}
