package dev.norbiros.skytopautomizer.administration;
import dev.norbiros.skytopautomizer.SkytopAutomizer;
import dev.norbiros.skytopautomizer.administration.AntyCaps;
import dev.norbiros.skytopautomizer.administration.AdminBot;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.multiplayer.ServerData;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.multiplayer.PlayerInfo;

@Mod.EventBusSubscriber(modid = SkytopAutomizer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ChatHandler {
    
  @SubscribeEvent
  public static void onClientChat(ClientChatReceivedEvent event) {

    final Pattern pattern = Pattern.compile("[♀♂? ]?[ ]?(\\[(.*?)\\])?( )?(.*?):[ ]?(.*)");
    final Pattern nickPattern = Pattern.compile("(\\[(.*?)\\])?( )?([^ ]*)[ ]?[♀♂? ]?[ AFK]?");
    final Pattern privateMessagePattern = Pattern.compile("PW (.*?) -> (.*?): (.*)");
    Matcher matcher = pattern.matcher( event.getMessage().getString() );
    Matcher privateMessageMatcher = privateMessagePattern.matcher( event.getMessage().getString() );
    
    boolean userIsOnServer = Minecraft.getInstance().getCurrentServer().ip == "skytop.pl";

    if (privateMessageMatcher.find()) {
      if (privateMessageMatcher.group(2) == "Ja") {
        if (AdminBot.handleMessage(privateMessageMatcher.group(1), privateMessageMatcher.group(3)) == 1) {
          event.setCanceled(true);
        }
      } else if (privateMessageMatcher.group(3).contains("[AB]")) {
        event.setCanceled(true);
      }
    } else if (matcher.find()) { 
      String userName = matcher.group(4);
      String chatMessage = matcher.group(5);
      String loopNick;
      Matcher nickMatcher;

      // Replace all nicknames with "<nick>"
      for (PlayerInfo s : Minecraft.getInstance().getConnection().getOnlinePlayers()) {
        nickMatcher = nickPattern.matcher( s.getTabListDisplayName().getString() );
        if (nickMatcher.find()) {
          loopNick = nickMatcher.group(4);
          loopNick.replace(" ", "");
          chatMessage = chatMessage.replaceAll("(?i)" + loopNick, "<nick>");
        }
      }

      // Test chat message
      if (chatMessage.contains("lol")) {
        System.out.println("[SKYTOPAUTOMIZER] Test auto reply!");
        Minecraft.getInstance().player.chat("/a " + userName + " kocha torwika <3!");
      }

      AntyCaps.handleMessage(userName, chatMessage);
    }
  }
}