package de.krisp.arkoessentails.functions;

import de.krisp.arkoessentails.ArkoEssentails;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class CheckServerFunction  {

    public static boolean enabled = true;

    public CheckServerFunction() {
         check();
    }

    public void check() {
        if (enabled) {
            if (MinecraftClient.getInstance().getCurrentServerEntry() != null) {
                ArkoEssentails.LOGGER.info(MinecraftClient.getInstance().getCurrentServerEntry().address);
                if (MinecraftClient.getInstance().getCurrentServerEntry().address.equalsIgnoreCase("arkonius.de")) {

                    if (MinecraftClient.getInstance().player != null) {
                        MinecraftClient.getInstance().player.playSound(SoundEvents.ENTITY_ARROW_HIT_PLAYER, 100, 0);
                        MinecraftClient.getInstance().player.sendChatMessage("/fly");
                        MinecraftClient.getInstance().player.sendChatMessage("/feed");
                        ArkoEssentails.LOGGER.debug("executed /fly and /feed!");
                        enabled = false;
                    }
                }
            }
        }
    }
}
