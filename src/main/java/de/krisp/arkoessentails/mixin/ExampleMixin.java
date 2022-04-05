package de.krisp.arkoessentails.mixin;

import de.krisp.arkoessentails.ArkoEssentails;
import de.krisp.arkoessentails.functions.CheckItemdamageFunction;
import de.krisp.arkoessentails.functions.CheckServerFunction;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ConnectScreen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.network.ServerAddress;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MultiplayerScreen.class)
public class ExampleMixin {


	@Inject(at = @At("TAIL"), method = "init()V")
	private void init(CallbackInfo info) {

		CheckServerFunction.enabled = true;
		if (CheckItemdamageFunction.scheduler != null)
		CheckItemdamageFunction.scheduler.shutdown();
	}
}