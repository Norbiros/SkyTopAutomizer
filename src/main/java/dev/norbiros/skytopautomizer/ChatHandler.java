package dev.norbiros.skytopautomizer;
import dev.norbiros.skytopautomizer.administration.AntyCaps;
import dev.norbiros.skytopautomizer.administration.ChatComplete;
import dev.norbiros.skytopautomizer.administration.PrivateAdminBot;
import dev.norbiros.skytopautomizer.other.*;
import dev.norbiros.skytopautomizer.administration.*;


import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.client.Minecraft;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.multiplayer.PlayerInfo;

@Mod.EventBusSubscriber(modid = SkytopAutomizer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ChatHandler {
    
  @SubscribeEvent
  public static void onClientChat(ClientChatReceivedEvent event) {

    final Pattern pattern = Pattern.compile("[♀♂? ]?[ ]?(\\[(.*?)\\])?(Gracz)?( )?(.*?):[ ]?(.*)");
    final Pattern nickPattern = Pattern.compile("(\\[(.*?)\\])?( )?([^ ]*)[ ]?[♀♂? ]?[ AFK]?");
    final Pattern privateMessagePattern = Pattern.compile("PW (.*?) -> (.*?): (.*)");
    final Pattern welcomePattern = Pattern.compile("Przywitaj nowego gracza (.*) aby");
    Matcher matcher = pattern.matcher( event.getMessage().getString() );
    Matcher privateMessageMatcher = privateMessagePattern.matcher( event.getMessage().getString() );
    Matcher welcomeMatcher = welcomePattern.matcher( event.getMessage().getString() );
    
    boolean userIsOnServer = Minecraft.getInstance().getCurrentServer().ip == "skytop.pl";
    System.out.println("[SKYTOPAUTOMIZER] Player plays on SkyTop: " + userIsOnServer);
    if (!userIsOnServer) {
      System.out.println("[SKYTOPAUTOMIZER] Player plays on: " + Minecraft.getInstance().getCurrentServer().ip);
    }

    if (privateMessageMatcher.find()) {
      if (privateMessageMatcher.group(2).equalsIgnoreCase("Ja")) {
        if (PrivateAdminBot.handleMessage(privateMessageMatcher.group(1), privateMessageMatcher.group(3)) == 1) {
          event.setCanceled(true);
        }
      } else if (privateMessageMatcher.group(3).contains("[AB]")) {
        System.out.println("[SKYTOPAUTOMIZER] Hide AutoReply message: " + event.getMessage().getString() );
        event.setCanceled(true);
      }
    } else if (welcomeMatcher.find()) {
      AutoWelcomer.handleMessage(welcomeMatcher.group(1));
    } else if (matcher.find()) { 
      String rank = matcher.group(2);
      String userName = matcher.group(5).replace(" ", "");
      String chatMessage = matcher.group(6);
      String loopNick;
      Matcher nickMatcher;

      // Replace all nicknames with "<nick>"
      for (PlayerInfo s : Minecraft.getInstance().getConnection().getOnlinePlayers()) {
        if (s.getTabListDisplayName() != null) {
          nickMatcher = nickPattern.matcher(s.getProfile().getName());
          System.out.println("[SKYTOPAUTOMIZER] Test Nickname: " + s.getProfile().getName());
          if (nickMatcher.find()) {
            loopNick = nickMatcher.group(4).replace(" ", "");
            System.out.println("[SKYTOPAUTOMIZER] Loop Nickname: " + nickMatcher.group(4).replace(" ", ""));
            chatMessage = chatMessage.replaceAll("(?i)" + loopNick, "<nick>");
          }
        }
      }

      // Test chat message
      if (chatMessage.contains("lol")) {
        System.out.println("[SKYTOPAUTOMIZER] Test auto reply!");
        Minecraft.getInstance().player.chat("/a " + userName + " kocha torwika <3!");
      }

      AdminDetectorHandler.handleMessage(userName, rank, chatMessage);
    }
  }
}