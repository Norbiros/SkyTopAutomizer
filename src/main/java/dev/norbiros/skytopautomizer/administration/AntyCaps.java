package dev.norbiros.skytopautomizer.functions;
import dev.norbiros.skytopautomizer.SkytopAutomizer;


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
public class FastMath {
  
  public static Map<String, Integer> warnings = new HashMap<String, Integer>();
  
  @SubscribeEvent
  public static void onClientChat(ClientChatReceivedEvent event) {

    final Pattern pattern = Pattern.compile("[♀♂? ]?[ ]?(\\[(.*?)\\])?( )?(.*?):[ ]?(.*)");
    final Pattern nickPattern = Pattern.compile("(\\[(.*?)\\])?( )?([^ ]*)[ ]?[♀♂? ]?[ AFK]?");
    Matcher matcher = pattern.matcher( event.getMessage().getString() );
    
    boolean userIsOnServer = Minecraft.getInstance().getCurrentServer().ip == "skytop.pl";

    int fastCapsLetterAmount = 0;
	  for (int i = 0; i < event.getMessage().getString().length(); i++) {
      char letter = event.getMessage().getString().charAt(i);
      if (letter >= 65 && letter <= 90) {
        fastCapsLetterAmount = fastCapsLetterAmount + 1;
      }
    }
    
    if (matcher.find() && userIsOnServer && fastCapsLetterAmount >= 4) {      
      String player = matcher.group(4);
      String nickname;
      String chatMessage = matcher.group(5);
      Matcher nickMatcher;

      // Replace all nicknames with "<nick>"
      for (PlayerInfo s : Minecraft.getInstance().getConnection().getOnlinePlayers()) {
        nickMatcher = nickPattern.matcher( s.getTabListDisplayName().getString() );
        if (nickMatcher.find()) {
          nickname = nickMatcher.group(4);
          nickname.replace(" ", "");
          chatMessage = chatMessage.replaceAll("(?i)" + nickname, "<nick>");
        }
      }

      // Test chat message
      if (chatMessage.contains("lol")) {
        System.out.println("[SKYTOPAUTOMIZER] Test auto reply!");
        Minecraft.getInstance().player.chat("/a " + player + " kocha torwika <3!");
      }

      // Calculate caps letter amount
      int chatMessageLength = chatMessage.replace(" ", "").length();
	    int capsLetterAmount = 0;
	    for (int i = 0; i < chatMessage.length(); i++) {
        char letter = chatMessage.charAt(i);
        if (letter >= 65 && letter <= 90) {
          capsLetterAmount = capsLetterAmount + 1;
        }
      }

      boolean capsMessage = capsLetterAmount >= 4 && (((double)capsLetterAmount / (double)chatMessageLength) >= 0.5);

      if (capsMessage) {
        if (!warnings.containsKey(player)) {
          System.out.println("I'm adding warning for " + player);
          warnings.put(player, 1);
        }
        
        if (warnings.get(player) == 2) {
          Minecraft.getInstance().player.chat("/mute " + player + "30min caps");
          System.out.println("[SKYTOPAUTOMIZER] Mute player for caps: " + player);
          warnings.put(player, 0);
        } else {
            Minecraft.getInstance().player.chat("Uważaj na caps " + player);
            System.out.println("[SKYTOPAUTOMIZER] Warn for caps to player " + player);
            warnings.put(player, warnings.get(player) + 1);
        }
      }
    }
  }
} 