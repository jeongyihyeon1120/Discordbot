package creeper0809.discordbot;

import java.io.IOException;

import javax.security.auth.login.LoginException;

import com.jagrosh.jdautilities.command.CommandClientBuilder;

import creeper0809.discordbot.objects.Config;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
	public static JDA jda;
	public static void main(String[] args) throws IOException {
		try {
			jda = JDABuilder.createDefault(Config.get("token"))
					.addEventListeners(new Listener())
					.build();
		} catch (LoginException e) {
			e.printStackTrace();
		}
	}
}
