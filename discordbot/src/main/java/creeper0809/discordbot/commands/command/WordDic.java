package creeper0809.discordbot.commands.command;

import java.util.Arrays;
import java.util.List;

import creeper0809.discordbot.DicCrawl;
import creeper0809.discordbot.commands.CommandContext;
import creeper0809.discordbot.commands.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

public class WordDic implements ICommand{

	@Override
	public void handle(CommandContext context) {
		MessageEmbed eb = new EmbedBuilder()
				.setTitle(context.getArgs().get(0)+"의 검색 결과")
				.setDescription(new DicCrawl().isthere(context.getArgs().get(0)))
				.build();
		context.getChannel().sendMessage(eb).queue();
	}

	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return "단어를 검색해줍니다";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "단어검색";
	}

	@Override
	public List<String> getAliases() {
		// TODO Auto-generated method stub
		return Arrays.asList("단어","단어검색");
	}

}
