package com.miqhtie.testmod.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class TestCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "testmod";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "/" + getCommandName();
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] strings) throws CommandException {
        Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "Test " + EnumChatFormatting.GREEN + "test test"));
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}
