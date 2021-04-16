package creeper0809.discordbot.commands.command;
import java.util.Arrays;
import java.util.List;

import creeper0809.discordbot.commands.CommandContext;
import creeper0809.discordbot.commands.ICommand;

/**
 * <pre>
 * creeper0809.discordbot.commands.command 
 * SayHi.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2021. 4. 16.
 * @author : yhyeon
 * @version : v1.0
 */
public class SayHi implements ICommand {

	@Override
	public void handle(CommandContext context) {
		context.getChannel().sendMessage("안녕").queue();	
	}

	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return "인사를 해준다";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "안녕";
	}

	@Override
	public List<String> getAliases() {
		// TODO Auto-generated method stub
		return Arrays.asList("안녕");
	}
	

}
