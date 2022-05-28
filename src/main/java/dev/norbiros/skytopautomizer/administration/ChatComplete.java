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

public class ChatComplete {
    
  public static void handleMessage(String chatMessage) {
    switch (chatMessage.toUpperCase()) {
      case "SKRZYNKI":
        sendMessage("Klucze zdobędziesz za np. eventy, odpowiadanie na szybką matmę, oraz głosowanie na nasz serwer (komenda /listy). Skrzynke otworzysz klikając na nią prawym klawiszem na /warp skrzynki. Jeśli chcesz sprawdzić ilość kluczy, użyj komendy /klucze";
        break;
      case "AUTOCHATCOMPLETE":
      case "CHATCOMPLETE":
        sendMessage("AutoChatComplete to funkcja AdminBot, która pomaga administracji w odpowiedziach na pytania graczy.";
        break;
      case "START":
        sendMessage("Witaj! Jeśli chcesz zacząć, użyj komendy /kit, aby odebrać itemy na start. Następnie zagłosuj na nasz serwer (/listy), aby otrzymać darmowe klucze. Potem pójdź na /rtp i rozpocznij grę!";
        break;
      default:
        break;
    }
  }

  public static void sendMessage(String message) {
    Minecraft.getInstance().player.chat(message);
  }
} 