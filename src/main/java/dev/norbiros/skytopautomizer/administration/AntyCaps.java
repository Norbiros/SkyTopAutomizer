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

@Mod.EventBusSubscriber(modid = SkytopAutomizer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class AntyCaps {
    
  @SubscribeEvent
  public static void onClientChat(ClientChatReceivedEvent event) {
    System.out.println("s");
    System.out.println(Minecraft.getInstance().level.getScoreboard().toString());
    System.out.println(Minecraft.getInstance().level.getScoreboard().getDisplayObjective(1).toString());
    System.out.println(Minecraft.getInstance().level.getScoreboard().getDisplaySlotName(1));
    System.out.println(Minecraft.getInstance().level.getScoreboard().getDisplaySlotNames());
    System.out.println(Minecraft.getInstance().level.getScoreboard().getObjectiveNames());
    System.out.println(Minecraft.getInstance().level.getScoreboard().getObjectives().toString());
    System.out.println(Minecraft.getInstance().level.getScoreboard().getPlayerScores("Norbiros").toString());
  }
} 
