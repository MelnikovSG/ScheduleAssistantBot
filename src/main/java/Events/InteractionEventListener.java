package Events;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class InteractionEventListener extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        super.onSlashCommandInteraction(event);

        switch (event.getName()) {
            case "hi" -> event.reply("Привет тебе путник!").setEphemeral(true).queue();
            case "goodbye" -> event.reply("Bye bye").setEphemeral(true).queue();
            case "weather" -> event.reply("В каком городе ты живешь?").setEphemeral(true).queue();
        }
    }
}
