package de.krisp.arkoessentails.mixin;

import de.krisp.arkoessentails.functions.CheckItemdamageFunction;
import de.krisp.arkoessentails.functions.CheckServerFunction;
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