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

public class PrivateAdminBot {
  
  public static String commandExecutor;
  
  public static int handleMessage(String nickName, String chatMessage) {
    commandExecutor = nickName;
    if (chatMessage.contains("/info")) {
      System.out.println("[SKYTOPAUTOMIZER] Info command!" );
      sendDirectMessage("[AB] AdminBot v.1!");
      sendDirectMessage("[AB] Witaj w menu bota stworzonego przez @Norbiros");
      sendDirectMessage("[AB] Bot jest w trakcie programowania!");
      sendDirectMessage("");
      sendDirectMessage("[AB] Obecne komendy:");
      sendDirectMessage("[AB] !helper - pomóż Norbirosowi");
      sendDirectMessage("[AB] !info - lista komend");
    } else if (chatMessage.contains("/helper")) {
      System.out.println("[SKYTOPAUTOMIZER] Helper command!" );
      sendDirectMessage("[AB] Norbiros stworzył AutoModa, który sam zgaszał caps na chat...");
      sendDirectMessage("[AB] Niestety pewne osoby, znalazły błąd, i spowodowały");
      sendDirectMessage("[AB] że mod ciągle spamował...");
      sendDirectMessage("[AB] Z tego powodu @Norbiros został wyrzucony z Administracji...");
      sendDirectMessage("[AB] Teraz próbuje zrobić wszystko, aby powrócić!");
      sendDirectMessage("[AB] Jeśli chcesz mu pomóc, daj mu podpis");
      sendDirectMessage("[AB] w '/dzialka odwiedz KrolestwoSzczytow'!");
    } else {
      return 0;
    }
    System.out.println("[SKYTOPAUTOMIZER] AutoReply worked!" );
    return 1;
  }

  public static void sendMessage(String message) {
    Minecraft.getInstance().player.chat(message);
  }

  public static void sendDirectMessage(String message) {
    Minecraft.getInstance().player.chat("/msg " + commandExecutor + " " + message);
  }
} 