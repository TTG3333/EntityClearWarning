package com.github.ttg3333.entityclearwarning.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChatHud.class)
public class ChatHudMixin {
    @Inject(method = "addMessage(Lnet/minecraft/text/Text;I)V", at = @At("HEAD"), cancellable = true)
    private void addMessage(Text text, int id, CallbackInfo ci) {
        if (text.getString().equals("Cleaner » Entities will be cleared in 1 minute!")) {
            MinecraftClient.getInstance().inGameHud.setTitles(null, Text.of("§cEntity cleaner in 1 minute!"), 50, 400, 50);
            MinecraftClient.getInstance().inGameHud.setTitles(Text.of(""), null, 50, 400, 50);
            System.out.println(text.getString());
        } else if (text.getString().equals("Cleaner » Entities will be cleared in 10 seconds!")) {
            MinecraftClient.getInstance().inGameHud.setTitles(null, Text.of("§cEntity cleaner in 10 seconds!"), 50, 400, 50);
            MinecraftClient.getInstance().inGameHud.setTitles(Text.of(""), null, 50, 400, 50);
            System.out.println(text.getString());
        }
    }
}
