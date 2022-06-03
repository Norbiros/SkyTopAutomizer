package dev.norbiros.skytopautomizer.other;

import net.minecraft.client.Minecraft;
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
        case 0 -> sendMessage("Hej " + nickName);
        case 1 -> sendMessage("Czesc " + nickName);
        case 2 -> sendMessage("kaka sraka małego ptaka " + nickName);
        default -> sendMessage("uwu " + nickName);
      }
    }
  }

  public static void sendMessage(String message) {
    Minecraft.getInstance().player.chat(message);
  }
} 