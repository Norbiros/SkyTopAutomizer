package dev.norbiros.skytopautomizer.other;
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
import java.util.Random;

public class AutoWelcomer {
    
  public static void handleMessage(String nickName) {
    Random rand = new Random();
    int time = rand.nextInt(300);
    time = (time + 400) * 10;
    try {
      Thread.sleep(time);
    } catch(InterruptedException ex) {
      System.out.println("[SKYTOPAUTOMIZER] Unexpected error: " + ex);
    }
    if (rand.nextInt(2) == 0) {
      switch (rand.nextInt(4)) {
        case 0:
          sendMessage("Hej " + nickName);
          break;
        case 1:
          sendMessage("Czesc " + nickName);
          break;
        case 2:
          sendMessage("witaj " + nickName);
          break;
        default:
          sendMessage("hej " + nickName);
          break;
      }
    }
  }

  public static void sendMessage(String message) {
    Minecraft.getInstance().player.chat(message);
  }
} 