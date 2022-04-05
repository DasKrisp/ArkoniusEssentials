package de.krisp.arkoessentails.mixin;

import de.krisp.arkoessentails.ArkoEssentails;
import de.krisp.arkoessentails.functions.CheckItemdamageFunction;
import de.krisp.arkoessentails.functions.CheckServerFunction;
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

import java.util.List;

@Mixin(ChatHud.class)
public class ChatMixin {

    @Shadow
    private List<ChatHudLine<OrderedText>> visibleMessages;

    @Shadow
    private MinecraftClient client;

    @Inject(at = @At("HEAD"),
            method = "addMessage(Lnet/minecraft/text/Text;I)V",
            cancellable = true)
    private void onAddMessage(Text chatText, int chatLineId, CallbackInfo ci)
    {
        new CheckItemdamageFunction();
        new CheckServerFunction();
    }
}

