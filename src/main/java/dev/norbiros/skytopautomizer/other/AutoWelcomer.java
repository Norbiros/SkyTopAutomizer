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
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class AutoWelcomer {
    
  public static void handleMessage(String nickName) {
    Random rand = new Random();
    int time = rand.nextInt(3);
    time = time + 1;
    TimeUnit.SECONDS.sleep(time);
    sendMessage("Hej " + nickName);
  }

  public static void sendMessage(String message) {
    Minecraft.getInstance().player.chat(message);
  }
} 