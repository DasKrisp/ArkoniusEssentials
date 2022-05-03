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
import net.minecraft.client.gui.screen.ConnectScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ConnectScreen.class)
public class ConnectScreenMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		CheckServerFunction.enabled = true;
		if (CheckItemdamageFunction.scheduler != null)
		CheckItemdamageFunction.scheduler.shutdown();
	}
}