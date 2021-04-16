package creeper0809.discordbot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import creeper0809.discordbot.commands.CommandContext;
import creeper0809.discordbot.commands.ICommand;
import creeper0809.discordbot.commands.command.SayHi;
import creeper0809.discordbot.commands.command.ShowHelp;
import creeper0809.discordbot.commands.command.WordDic;
import creeper0809.discordbot.objects.Config;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandManager {
	List<ICommand> commands = new ArrayList<ICommand>();
	public CommandManager() {
		addCommand(new ShowHelp(this));
		addCommand(new WordDic());
		addCommand(new SayHi());
	}
	private void addCommand(ICommand command) {
		boolean hasCommand = this.commands.stream().anyMatch((it)->it.getName()
				.equalsIgnoreCase(command.getName()));
		if(hasCommand) {
			System.out.println("이미 존재하는 커맨드입니다");
		}
		commands.add(command);
	}
	private ICommand getCommand(String commandName) {
		for(ICommand cmd : commands) {
			if(cmd.getName().equals(commandName)||cmd.getAliases().contains(commandName)) {
				return cmd;
			}
		}
		return null;
	}
	public void handlecommand(MessageReceivedEvent e) {
		final String[] message = e.getMessage().getContentRaw()
				.replaceFirst(Pattern.quote(Config.get("prefix")), "")
				.split("\\s");
		final String invoke = message[0].toLowerCase();
		ICommand cmd = this.getCommand(invoke);
		
		if(cmd != null) {
			List<String> args = Arrays.asList(message).subList(1, message.length);
			CommandContext context = new CommandContext(e, args);
			cmd.handle(context);
		}
	}
	public List<ICommand> getCommands(){
		return commands;
	}
}
