package dev.norbiros.skytopautomizer.administration;

import net.minecraft.client.Minecraft;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AdminDetectorHandler {

    public static Map<String, HashMap<Integer, String>> warnings = new HashMap<String, HashMap<Integer,String>>();
    public static void handleMessage(String nickName, String rank, String chatMessage) {
        if (chatMessage.startsWith(".")) {
            if (rank.equals("HELPER") || rank.equals("MOD") || rank.equals("ADMIN") || rank.equals("WŁAŚCICIEL") || rank.equals("W?A?CICIEL") || nickName.equals("Norbiros")) {
                ChatComplete.handleMessage(chatMessage.replace(".", ""));
            }
        }


        if(warnings.get(nickName).keySet().stream().findFirst().isEmpty()){
            HashMap<Integer, String> innerBatterMap = new HashMap<Integer, String>();
            innerBatterMap.put(1, "caps");
            warnings.put(nickName, innerBatterMap);

        }

        HashMap<Integer, String> innerBatterMapa = new HashMap<Integer, String>();
        if (warnings.get(nickName).keySet().stream().findFirst().equals(2)) {
            innerBatterMapa.put(2, "caps");
            Minecraft.getInstance().player.chat("/mute " + nickName + "30min");
            System.out.println("[SKYTOPAUTOMIZER] Mute player for caps: " + nickName);
        } else {
            Minecraft.getInstance().player.chat("Uważaj na caps " + nickName);
            System.out.println("[SKYTOPAUTOMIZER] Warn for caps to player " + nickName);
            innerBatterMapa.put(warnings.get(nickName).keySet().stream().findFirst().get() + 1, "caps");
        }
        warnings.put(nickName, innerBatterMapa);
    }
}
