import Events.InteractionEventListener;
import Events.MessageEventListener;
import Events.ReadyEventListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import property.LoadConfig;

public class DiscordBot {
    public static void main(String[] args) {

        JDABuilder jdaBuilder = JDABuilder.createDefault
                (new LoadConfig().loadConfig("TOKEN"));
        JDA jda = jdaBuilder.enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
                .addEventListeners(new ReadyEventListener(), new MessageEventListener()
                        , new InteractionEventListener()).build();
        jda.upsertCommand("hi", "say hi").setGuildOnly(true).queue();
        jda.upsertCommand("goodbye", "say bye").setGuildOnly(true).queue();
        jda.upsertCommand("weather",
                "Find out what the weather is in your city").setGuildOnly(true).queue();
    }
}
