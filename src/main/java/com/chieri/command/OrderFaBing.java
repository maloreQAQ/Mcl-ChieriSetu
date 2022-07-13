package com.chieri.command;

import com.chieri.Plugin;
import com.chieri.config.FaBingMessage;
import net.mamoe.mirai.console.command.CommandSender;
import net.mamoe.mirai.console.command.java.JSimpleCommand;
import net.mamoe.mirai.contact.NormalMember;

public final class OrderFaBing extends JSimpleCommand {
    public OrderFaBing()
    {
        super(Plugin.INSTANCE,"指定发病");
        setPrefixOptional(true);
    }
    @Override
    public String getUsage() {return "/指定发病 某人";}
    @Handler
    public void onCommand(CommandSender sender ,NormalMember target)
    {
        sender.sendMessage(new FaBingMessage().getFaBingMessage(target.getId()));
    }
}
