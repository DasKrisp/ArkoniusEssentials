package de.krisp.arkoessentails.functions;

import de.krisp.arkoessentails.ArkoEssentails;
import net.minecraft.client.MinecraftClient;
import net.minecraft.sound.SoundEvents;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CheckItemdamageFunction {

    public CheckItemdamageFunction() {
        startSchedular();
    }

    public static ScheduledExecutorService scheduler;

    public void startSchedular() {
        if (CheckServerFunction.enabled) {
            scheduler = Executors.newScheduledThreadPool(1);
            scheduler.scheduleAtFixedRate(() -> {
                if (MinecraftClient.getInstance().player != null) {
                    if (MinecraftClient.getInstance().player.getInventory().getMainHandStack() != null) {
                        int Damage = MinecraftClient.getInstance().player.getInventory().getMainHandStack().getDamage();
                        int MaxDamage = MinecraftClient.getInstance().player.getInventory().getMainHandStack().getMaxDamage();
                        int Durability = MaxDamage - Damage;

                        ArkoEssentails.LOGGER.debug("Durability of your MainHand Item " + Durability);

                        if (Durability <= MaxDamage / 4 && Durability != 0) {
                            ArkoEssentails.LOGGER.debug("The Durability of your MainHand item is low. Send repair command");
                            MinecraftClient.getInstance().player.sendChatMessage("/repair");
                            MinecraftClient.getInstance().player.playSound(SoundEvents.ENTITY_ARROW_HIT_PLAYER, 100, 0);
                        }
                    }
                }
            }, 10, 10, TimeUnit.SECONDS);
        }
    }
}
