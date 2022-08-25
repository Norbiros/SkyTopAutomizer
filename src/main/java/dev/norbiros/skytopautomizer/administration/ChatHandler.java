package dev.norbiros.skytopautomizer.administration;
import dev.norbiros.skytopautomizer.SkytopAutomizer;
import dev.norbiros.skytopautomizer.administration.*;
import dev.norbiros.skytopautomizer.other.*;


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

@Mod.EventBusSubscriber(modid = SkytopAutomizer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ChatHandler {
  @SubscribeEvent
  public static void onClientChat(ClientChatReceivedEvent event) {
    String s = Minecraft.getInstance().level.getScoreboard().getDisplaySlotName(0);
    System.out.println(s);
  }
}
