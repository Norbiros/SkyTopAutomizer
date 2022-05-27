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

public class AdminBot {
    
  public static int handleMessage(String nickName, String chatMessage) {
      System.out.println("[SKYTOPAUTOMIZER] AdminBot handle message: " + nickName + " " + chatmessage );
      if (chatMessage.contains("/info")) {
        System.out.println("[SKYTOPAUTOMIZER] Info command!" );
        sendMessage("/msg " + nickName + "[AB] AdminBot v.1!");
        sendMessage("/msg " + nickName + "[AB] Witaj w menu bota stworzonego przez @Norbiros");
        sendMessage("/msg " + nickName + "[AB] Obecne komendy:");
        sendMessage("/msg " + nickName + "[AB] /helper");
        sendMessage("/msg " + nickName + "[AB] /info");
      } else if (chatMessage.contains("/helper")) {
        System.out.println("[SKYTOPAUTOMIZER] Helper command!" );
        sendMessage("/msg " + nickName + "[AB] Norbiros stworzył AutoModa, który sam zgaszał caps na chat...");
        sendMessage("/msg " + nickName + "[AB] Niestety pewne osoby, znalazły błąd, i spowodowały");
        sendMessage("/msg " + nickName + "[AB] że mod ciągle spamował...");
        sendMessage("/msg " + nickName + "[AB] Z tego powodu @Norbiros został wyrzucony z Administracji...");
        sendMessage("/msg " + nickName + "[AB] Teraz próbuje zrobić wszystko, aby powrócić!");
        sendMessage("/msg " + nickName + "[AB] Jeśli chcesz mu pomóc, daj mu podpis");
        sendMessage("/msg " + nickName + "[AB] w '/dzialka odwiedz KrolestwoSzczytow'!");
      } else {
        System.out.println("[SKYTOPAUTOMIZER] AutoReply doesnt work!" );
        return 0;
      }
      System.out.println("[SKYTOPAUTOMIZER] AutoReply!" );
      return 1;
  }

  public static void sendMessage(String message) {
    Minecraft.getInstance().player.chat(message);
  }
} 