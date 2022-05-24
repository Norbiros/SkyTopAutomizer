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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Mod.EventBusSubscriber(modid = SkytopAutomizer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class FastMath {
  
  @SubscribeEvent
  public static void onClientChat(ClientChatReceivedEvent event) {

    Pattern pattern = Pattern.compile("^[♂♀]?[ ]?\\[(.*?)\\] (.*?):[ ]?(.*)");
    Matcher matcher = pattern.matcher( event.getMessage().getString() );
    
    if (matcher.find()) {
      String substring = "uwu";
      if (event.getMessage().getString().contains(substring)) {
        Minecraft.getInstance().player.chat("/a Ktoś napisał UWU na chat <3");
      }
    
      String chatMessage = matcher.group(3);
		  int chatMessageLength = chatMessage.replace(" ", "").length();
		  int capsLetterAmount = 0;
		  for (int i = 0; i < chatMessage.length(); i++) {
        char letter = chatMessage.charAt(i);
        if (letter >= 65 && letter <= 90) {
          capsLetterAmount = capsLetterAmount + 1;
        }
      }
    
      if (capsLetterAmount >= 5 && ((double)capsLetterAmount / (double)chatMessageLength) >= 0.5) ) {
        Minecraft.getInstance().player.chat("Uważaj na capslock!");
      }
      
    }
  }
}