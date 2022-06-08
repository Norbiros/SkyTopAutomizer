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


        System.out.println("LOADING ADMINHADNLER!");
        HashMap<Integer, String> warningData = new HashMap<Integer, String>();

        int warn = AntyCaps.handleMessage(nickName); 
        System.out.println("HANDLED CAPS " + warn);

        if (!warnings.contains(nickName)) {
            warningData.put(1, "caps");
            warnings.put(nickName, warningData);
            System.out.println("New warning for caps");
        }

        if (warnings.get(nickName).keySet().stream().findFirst().equals(2)) {
            warningData.put(2, "caps");
            Minecraft.getInstance().player.chat("/mute " + nickName + "30min");
            System.out.println("[SKYTOPAUTOMIZER] Mute player for caps: " + nickName);
        } else {
            Minecraft.getInstance().player.chat("Uważaj na caps " + nickName);
            System.out.println("[SKYTOPAUTOMIZER] Warn for caps to player " + nickName);
            warningData.put(warnings.get(nickName).keySet().stream().findFirst().get() + 1, "caps");
        }

        warnings.put(nickName, warningData);

        System.out.println("Nick: " + nickName);
        System.out.println("Warnings: " + warnings.get(nickName).keySet().stream().findFirst().isEmpty());
        System.out.println("Data: " + warnings.get(nickName).keySet().stream().skip(warnings.get(nickName).keySet().stream().count() - 1).findFirst().isEmpty());
    }
}
