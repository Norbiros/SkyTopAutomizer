package dev.norbiros.skytopautomizer.administration;

import net.minecraft.client.Minecraft;
import java.util.HashMap;
import java.util.Map;

public class AntyCaps {
    
  public static int handleMessage(String chatMessage) {

    int playerWarnings = 0;
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

    if (capsMessage) return 1;
    return 0;
  }
} 