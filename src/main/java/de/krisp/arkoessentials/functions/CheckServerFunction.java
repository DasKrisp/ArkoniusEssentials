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

public class CheckServerFunction {

    public static boolean enabled = true;

    public CheckServerFunction() {
        check();
    }

    public void check() {
        if (enabled) {
            if (MinecraftClient.getInstance().getCurrentServerEntry() != null) {
                ArkoEssentials.LOGGER.info(MinecraftClient.getInstance().getCurrentServerEntry().address);
                if (MinecraftClient.getInstance().getCurrentServerEntry().address.equalsIgnoreCase("arkonius.de")) {

                    if (MinecraftClient.getInstance().player != null) {
                        MinecraftClient.getInstance().player.playSound(SoundEvents.ENTITY_ARROW_HIT_PLAYER, 100, 0);
                        MinecraftClient.getInstance().player.sendChatMessage("/fly");
                        MinecraftClient.getInstance().player.sendChatMessage("/feed");
                        ArkoEssentials.LOGGER.debug("executed /fly and /feed!");
                        enabled = false;
                    }
                }
            }
        }
    }
}

