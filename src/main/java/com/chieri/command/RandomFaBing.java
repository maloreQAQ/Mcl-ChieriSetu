package com.chieri.command;

import com.chieri.Plugin;
import net.mamoe.mirai.console.command.CommandSender;
import net.mamoe.mirai.console.command.java.JSimpleCommand;
import net.mamoe.mirai.contact.NormalMember;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.message.data.*;
import com.chieri.config.FaBingMessage;
import java.util.Random;

import static net.mamoe.mirai.console.command.CommandSenderKt.getGroupOrNull;

public final class RandomFaBing extends JSimpleCommand {
    public RandomFaBing()
    {
        super(Plugin.INSTANCE,"随机发病");
        setPrefixOptional(true);
    }
    @Override
    public String getUsage(){return "/随机发病";}
    @Handler
    public void onCommand(CommandSender sender)
    {
        Random random = new Random();
        int randNum = random.nextInt(getGroupOrNull(sender).getMembers().toArray().length);
        NormalMember target = (NormalMember) getGroupOrNull(sender).getMembers().toArray()[randNum];
        final long targetID = target.getId();
        if(target == null)
        {
            sender.sendMessage("获取对象失败");
        }
        else
        {
            sender.sendMessage(new FaBingMessage().getFaBingMessage(targetID));
        }
    }
}
