package com.github.professorSam.supportNotificationDiscordBot;

import java.util.Collection;
import java.util.Optional;

import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.user.User;
import org.javacord.api.entity.user.UserStatus;
import org.javacord.api.event.channel.server.voice.ServerVoiceChannelMemberJoinEvent;
import org.javacord.api.listener.channel.server.voice.ServerVoiceChannelMemberJoinListener;

public class PlayerJoinWaitingChannelEvent implements ServerVoiceChannelMemberJoinListener{
	
	private final Long channelID = Long.parseLong(Settings.getWaitingChannelID());
	private final Long pingRole = Long.parseLong(Settings.getPingRole());
	@Override
	public void onServerVoiceChannelMemberJoin(ServerVoiceChannelMemberJoinEvent event) {
		if(event.getChannel().getId() == channelID) {
			Optional<Role> role = Main.getApi().getRoleById(pingRole);
			if(role.isEmpty()) {
				System.out.println("Can not find pingRole!");
				System.out.println("Shutting down bot!");
				System.exit(0);
				return;
			}
			Collection<User> notifyUsers = role.get().getUsers();
			for (User user : notifyUsers) {
				if(user.getStatus() == UserStatus.ONLINE) {
					EmbedBuilder embed = new EmbedBuilder()
							.setTitle("Support")
							.setDescription(Settings.getNotifyMessage())
							.setFooter("Made with <3 by ProfSam#3975");
					new MessageBuilder()
							.addEmbed(embed)
							.append("User: " + event.getUser().getDisplayName(event.getServer()))
							.send(user);
				}
			}
			
		}
	}
}
