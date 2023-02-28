package Events;

import entity.Weather;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import weather.Geocoding;
import weather.JsonWeatherParser;


public class MessageEventListener extends ListenerAdapter {
    JsonWeatherParser asd = new JsonWeatherParser();
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        super.onMessageReceived(event);
        MessageChannel messageChannel = event.getChannel();

        String city = event.getMessage().getContentDisplay();
        asd.parseWeather(new Geocoding().findCoordinate(city));
    }
}
