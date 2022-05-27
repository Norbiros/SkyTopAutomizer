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
      if (chatMessage.contains("/info")) {
        sendMessage("/msg " + nickName + "[AB] AdminBot v.1!");
        sendMessage("/msg " + nickName + "[AB] Witaj w menu bota stworzonego przez @Norbiros");
        sendMessage("/msg " + nickName + "[AB] Obecne komendy:");
        sendMessage("/msg " + nickName + "[AB] /helper");
        sendMessage("/msg " + nickName + "[AB] /info");
        return 1;
      } else (chatMessage.contains("/helper")) {
        sendMessage("[AB] Norbiros stworzył AutoModa, który sam zgaszał caps na chat...");
        sendMessage("[AB] Niestety pewne osoby, znalazły błąd, i spowodowały");
        sendMessage("[AB] że mod ciągle spamował...");
        sendMessage("[AB] Z tego powodu @Norbiros został wyrzucony z Administracji...");
        sendMessage("[AB] Teraz próbuje zrobić wszystko, aby powrócić!");
        sendMessage("[AB] Jeśli chcesz mu pomóc, daj mu podpis");
        sendMessage("[AB] w '/dzialka odwiedz KrolestwoSzczytow'!");
      }
      return 0;
  }

  public static void sendMessage(String message) {
    Minecraft.getInstance().player.chat(message);
  }
} 