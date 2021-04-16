package creeper0809.discordbot.commands;

import java.nio.channels.Channel;
import java.util.List;

import me.duncte123.botcommons.commands.ICommandContext;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class CommandContext {
	private MessageReceivedEvent event;
	private List<String> args;

	public CommandContext(MessageReceivedEvent event, List<String> args) {
		this.event = event;
		this.args = args;
	}

	public Guild getGuild() {
		return this.getEvent().getGuild();
	}

	public MessageReceivedEvent getEvent() {
		return this.event;
	}

	public MessageChannel getChannel() {
		return this.event.getChannel();
	}

	public List<String> getArgs() {
		return this.args;
	}
}
