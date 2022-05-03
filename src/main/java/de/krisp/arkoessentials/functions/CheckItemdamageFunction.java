/*
 * Copyright (c) 2022 DasKrisp
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this file,
 * You can obtain one at: https://www.gnu.org/licenses/
 */

package de.krisp.arkoessentials.functions;

import de.krisp.arkoessentials.ArkoEssentials;
import net.minecraft.client.MinecraftClient;
import net.minecraft.sound.SoundEvents;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CheckItemdamageFunction {

    public CheckItemdamageFunction() {
        startScheduler();
    }

    public static ScheduledExecutorService scheduler;

    public void startScheduler() {
        if (CheckServerFunction.enabled) {
            scheduler = Executors.newScheduledThreadPool(1);
            scheduler.scheduleAtFixedRate(() -> {
                if (MinecraftClient.getInstance().player != null) {
                    if (MinecraftClient.getInstance().player.getInventory().getMainHandStack() != null) {
                        int Damage = MinecraftClient.getInstance().player.getInventory().getMainHandStack().getDamage();
                        int MaxDamage = MinecraftClient.getInstance().player.getInventory().getMainHandStack().getMaxDamage();
                        int Durability = MaxDamage - Damage;

                        ArkoEssentials.LOGGER.debug("Durability of your MainHand Item " + Durability);

                        if (Durability <= MaxDamage / 4 && MinecraftClient.getInstance().player.getInventory().getMainHandStack().getItem().isDamageable() && Durability != 0) {
                            if (!(MinecraftClient.getInstance().getCurrentServerEntry() == null)) {
                                if (MinecraftClient.getInstance().getCurrentServerEntry().address.equalsIgnoreCase("arkonius.de")) {
                                    ArkoEssentials.LOGGER.debug("The Durability of your MainHand item is low. Send repair command");
                                    MinecraftClient.getInstance().player.sendChatMessage("/repair");
                                    MinecraftClient.getInstance().player.playSound(SoundEvents.ENTITY_ARROW_HIT_PLAYER, 100, 0);
                                }
                            }
                        }
                    }
                }
            }, 10, 10, TimeUnit.SECONDS);
        }
    }
}
