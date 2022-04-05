package de.krisp.arkoessentails.mixin;

import com.mojang.authlib.GameProfile;
import de.krisp.arkoessentails.ArkoEssentails;
import de.krisp.arkoessentails.commands.CommandManager;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class PlayerEntityMixin extends AbstractClientPlayerEntity {

    @Shadow
    private ClientPlayNetworkHandler networkHandler;

    public PlayerEntityMixin(ClientWorld world, GameProfile profile) {
        super(world, profile);
    }

    @Inject(at = @At("HEAD"),
            method = "sendChatMessage(Ljava/lang/String;)V",
            cancellable = true)
    private void onSendChatMessage(String message, CallbackInfo ci)
    {
        ArkoEssentails.LOGGER.info("CHAT : Player has send following Message = " + message);

        if(CommandManager.ExecuteCommand(message)) {
            ci.cancel();
        } else {

            ChatMessageC2SPacket packet =
                    new ChatMessageC2SPacket(message);
            networkHandler.sendPacket(packet);
            ci.cancel();
        }
    }



}
