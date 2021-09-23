package com.github.professorSam.supportNotificationDiscordBot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.activity.ActivityType;
import org.javacord.api.entity.user.UserStatus;

public class Main {
	private static DiscordApi api;
	public static void main(String args[]) {
		Settings.intialSettings();
		
		api = new DiscordApiBuilder()
				.setToken(Settings.getToken())
				.setAllIntents()
				.login().join();
		api.addListener(new PlayerJoinWaitingChannelEvent());
		api.updateStatus(UserStatus.ONLINE);
		api.updateActivity(ActivityType.PLAYING, "😋 Support!");
		System.out.println("Loaded!");
	}
	public static DiscordApi getApi() {
		return api;
	}
}
