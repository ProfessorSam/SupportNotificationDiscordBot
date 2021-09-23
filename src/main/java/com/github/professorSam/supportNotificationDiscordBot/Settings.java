package com.github.professorSam.supportNotificationDiscordBot;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Settings {
	private static String token;
	private static String waitingChannelID;
	private static String pingRole;
	private static String notifyMessage;
	private static String userNotifyMessage;
	private static String noModOnline;
	
	public static void intialSettings() {
		token = readStringFromFile("settings", "token.txt");
		waitingChannelID = readStringFromFile("settings",  "waitingChannelID.txt");
		pingRole = readStringFromFile("settings", "pingRole.txt");
		notifyMessage = readStringFromFile("settings", "notifyMessage.txt");
		userNotifyMessage = readStringFromFile("settings", "userNotifyMessage.txt");
		noModOnline = readStringFromFile("settings", "noModOnline.txt");
	}
	
	private static String readStringFromFile(String directory, String filename) {
		String returnString = null;
		try {
			returnString = Files.readString(Paths.get(directory, filename), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("There was an error while reading " + filename + ". Does it exist?");
			System.out.println("Shutting down Bot!");
			System.exit(0);
		}
		return returnString;
	}
	public static String getToken() {
		return token;
	}

	public static String getWaitingChannelID() {
		return waitingChannelID;
	}

	public static String getPingRole() {
		return pingRole;
	}

	public static String getNotifyMessage() {
		return notifyMessage;
	}

	public static String getUserNotifyMessage() {
		return userNotifyMessage;
	}

	public static String getNoModOnline() {
		return noModOnline;
	}
}
