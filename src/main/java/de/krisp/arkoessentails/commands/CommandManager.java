package de.krisp.arkoessentails.commands;

import de.krisp.arkoessentails.ArkoEssentails;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.MinecraftClientGame;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.MessageType;
import net.minecraft.text.Text;

public class CommandManager {
    public CommandManager() {}

    public static boolean ExecuteCommand(String Command) {

        //String[] args = Command.split(" ");

        if (Command.startsWith(".credits")) {
            MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.of("§2Credits to §a§lKrisp/chrisp1"));
            return true;
        }

        return false;
    }

}
