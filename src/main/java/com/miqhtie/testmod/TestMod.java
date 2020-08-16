package com.miqhtie.testmod;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = TestMod.MODID, version = TestMod.VERSION)
public class TestMod
{
    public static final String MODID = "testmod";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void chat(ClientChatReceivedEvent event){
        if(!event.message.getUnformattedText().toLowerCase().contains("poop")) return;
        event.setCanceled(true);
        String newMsg = event.message.getFormattedText().replaceAll("(?i)poop", "blocked-word");
        Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(newMsg));
    }
}
