package com.github.professorSam.supportNotificationDiscordBot;

import java.awt.Color;

import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.user.User;
import org.javacord.api.entity.user.UserStatus;
import org.javacord.api.event.channel.server.voice.ServerVoiceChannelMemberJoinEvent;
import org.javacord.api.listener.channel.server.voice.ServerVoiceChannelMemberJoinListener;

public class PlayerJoinWaitingChannelEvent implements ServerVoiceChannelMemberJoinListener {

	private final Long channelID = Long.parseLong(Settings.getWaitingChannelID());
	private final Long pingRole = Long.parseLong(Settings.getPingRole());

	@Override
	public void onServerVoiceChannelMemberJoin(ServerVoiceChannelMemberJoinEvent event) {
		if (event.getChannel().getId() == channelID) {
			event.getUser().sendMessage(Settings.getUserNotifyMessage());
			for (User mod : event.getServer().getRoleById(pingRole).get().getUsers()) {
				if (mod.getStatus() == UserStatus.ONLINE) {
					EmbedBuilder embed = new EmbedBuilder().setTitle("Support").setDescription(Settings.getNotifyMessage()).setFooter("Made with ❤️ by ProfSam#3975").setColor(Color.RED);
					new MessageBuilder().addEmbed(embed).append("User: " + event.getUser().getDisplayName(event.getServer())).send(mod);
				}
			}

			System.out.println("Waiting: " + event.getUser().getName().toString());
		}
	}
}
