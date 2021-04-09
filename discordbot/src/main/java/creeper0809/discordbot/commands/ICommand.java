package creeper0809.discordbot.commands;

import java.util.List;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface ICommand {
	void handle(CommandContext context);//명령어 들어오면 하는 동작
	String getHelp();//도움말 표시
	String getName();//이 명령어의 이름
	List<String> getAliases();
}
