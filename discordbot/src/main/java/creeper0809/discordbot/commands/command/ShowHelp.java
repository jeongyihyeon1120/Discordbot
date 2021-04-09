package creeper0809.discordbot.commands.command;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;

import creeper0809.discordbot.CommandManager;
import creeper0809.discordbot.commands.CommandContext;
import creeper0809.discordbot.commands.ICommand;
import creeper0809.discordbot.objects.Config;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class ShowHelp implements ICommand {
	public CommandManager manager;
	public ShowHelp(CommandManager manager) {
		this.manager = manager;
	}

	@Override
	public void handle(CommandContext context) {
		EmbedBuilder eb = new EmbedBuilder();
		eb.setTitle("봇 도움말");
		eb.setColor(Color.black);
		StringBuilder description = new StringBuilder();
		description.append("-----명령어-----\n");
		manager.getCommands().stream().forEach(
				(it) -> description.append(Config.get("prefix"))
				.append(it.getName()+" - ")
				.append(it.getHelp())
				.append("\n"));
		eb.setDescription(description.toString());
		context.getChannel().sendMessage(eb.build()).queue();
		
	}

	@Override
	public String getHelp() {
		return "도움말을 표시합니다";
	}

	@Override
	public List<String> getAliases() {
		// TODO Auto-generated method stub
		return Arrays.asList("도움", "도움말");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "도움말";
	}

}
