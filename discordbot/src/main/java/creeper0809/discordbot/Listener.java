package creeper0809.discordbot;

import creeper0809.discordbot.objects.Config;
import me.duncte123.botcommons.BotCommons;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Listener extends ListenerAdapter {
	// .queue() 가장 기본적인 작업후 호출 방법 호출 할 대상이 없으면 오류 발생
	// .submit() 더 이상 필요하지 않은 경우 실행을 취소해야 하는 경우
	CommandManager Cmanager = new CommandManager();
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
		if(e.getMessage().getContentRaw().equalsIgnoreCase(Config.get("prefix")+"shutdown") 
				&& e.getAuthor().getId().equals(Config.get("ownerid"))) {
			BotCommons.shutdown(e.getJDA());
		}	
		if (!e.getAuthor().isBot() && !e.getMessage().isWebhookMessage() &&
				e.getMessage().getContentRaw().startsWith(Config.get("prefix"))) {
			Cmanager.handlecommand(e);
		}
	}
}
