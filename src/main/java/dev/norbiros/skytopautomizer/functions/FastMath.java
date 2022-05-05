package dev.norbiros.skytopautomizer.functions;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FastMath {
  @SubscribeEvent
  public void onClientChat(ClientChatReceivedEvent event) {
    String message = (event.getMessage().getUnformattedText());
    if (message.matches("hej")) {
      getLocalPlayer().sendChatMessage("Reply");
    }
  }
}