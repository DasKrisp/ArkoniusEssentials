/*
 * Copyright (c) 2022 DasKrisp
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this file,
 * You can obtain one at: https://www.gnu.org/licenses/
 */

package de.krisp.arkoessentials.mixin;

import de.krisp.arkoessentials.functions.CheckItemdamageFunction;
import de.krisp.arkoessentials.functions.CheckServerFunction;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.gui.hud.ChatHudLine;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.*;

@Mixin(ChatHud.class)
public class ChatMixin {

    @Inject(at = @At("HEAD"),
            method = "addMessage(Lnet/minecraft/text/Text;I)V",
            cancellable = true)
    private void onAddMessage(Text chatText, int chatLineId, CallbackInfo ci)
    {
        new CheckItemdamageFunction();
        new CheckServerFunction();
    }
}

