# Discord Support Notification Bot

### What is it?

This is a open-source selfhosted bot which notifies all users of a certain role (ex. @Moderator or @Supporter) that a user has joined the voice-channel for example #waiting-for-support. Important is that only the Moderators who are online are notified. All messages and other stuff can be configured by yourself!

### Setup!

For this bot, you need:
- Obviously a Linux based Server (in my case Ubuntu 20.04)
- Screen (sudo apt-get install screen)
- At least Java 11 (apt install openjdk-11-jre-headless)

1)
First things first, you have to create a Botaccount on Discord! To do this, you have to go to the [Discord developer page](https://discord.com/developers/applications) (make sure you are logged in!) and create a new application. Than scroll a little bit down and activate "PRESENCE INTENT" and "SERVER MEMBERS INTENT"

2)
Navigate on the left side under Bot and click "Add Bot" and "Yes, do it!". Now you can set the profile picture and the name of your bot

3)
Now go to the [releases tab](https://github.com/ProfessorSam/SupportNotificationDiscordBot/releases) and download the latest "release.zip" and unzip it. The zip-file contains the a "start.sh", the settings directory and the .jar file of the bot

4)
Go back to you application on the Discord developer page and click under the username on Copy (Copy the token) and paste it into /settings/token.txt

5)
Now, copy the id of your moderator role and paste it into "/settings/pingRole.txt" and the id of the waiting-channel into "/settings/waitingChannelID.txt"

6)
Go to General information on the discord developer page and copy the Application ID. Copy the following Link and replace "id-here" in the link with your application id: "https://discord.com/oauth2/authorize?client_id=**ID-here**&scope=bot&permissions=8". Now open the link in you browser and select your server!

7)
Last step, execute the command "chmod +x start.sh" and do ./start.sh. Now your bot is ready and started! You can edit all messages in the /settings/ directory with the according .txt file


On Windows you can create a .bat file, pase the following lines of code and run it!

```bash
java -jar SupportNotifyBot.jar
pause
```

### Questions?
If there are any kind of problems, just send me a message on Discord (ProfSam#3975) or open an issue on GitHub