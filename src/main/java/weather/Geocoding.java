package weather;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import property.LoadConfig;

public class Geocoding {

    public String findCoordinate(String city) {
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" +
                    city + "&appid=" + new LoadConfig().loadConfig("OPEN_WEATHER_API_KEY"));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("Ошибка HTTP-кода: " + responseCode);
            } else {
                Scanner scanner1 = new Scanner(url.openStream());
                StringBuilder stringBuilder = new StringBuilder();
                while (scanner1.hasNext()) {
                    stringBuilder.append(scanner1.nextLine());
                }
                return stringBuilder.toString();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
