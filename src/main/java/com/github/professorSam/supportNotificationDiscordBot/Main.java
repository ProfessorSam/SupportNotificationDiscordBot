package com.github.professorSam.supportNotificationDiscordBot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Main {
	private static DiscordApi api;
	public static void main(String args[]) {
		Settings.intialSettings();
		
		api = new DiscordApiBuilder()
				.setToken(Settings.getToken())
				.login().join();
	}
	public static DiscordApi getApi() {
		return api;
	}
}
