package dev.norbiros.skytopautomizer.administration;
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

public class AntyCaps {
  
  public static Map<String, Integer> warnings = new HashMap<String, Integer>();
  
  public static void handleMessage(String nickName, String chatMessage) {
      
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
          System.out.println("[SKYTOPAUTOMIZER] I'm adding warning for " + player);
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