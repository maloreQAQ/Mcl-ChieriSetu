package com.chieri.command;

import com.chieri.Plugin;
import net.mamoe.mirai.console.command.CommandSender;
import net.mamoe.mirai.console.command.java.JSimpleCommand;
import net.mamoe.mirai.contact.NormalMember;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import static net.mamoe.mirai.console.command.CommandSenderKt.getGroupOrNull;

public final class kick extends JSimpleCommand {
    public kick()
    {
        super(Plugin.INSTANCE,"随机踢人");
        setPrefixOptional(true);
    }
    @Override
    public String getUsage(){return "/随机踢人";}
    @Handler
    public void onCommand(CommandSender Sender)
    {
        Random random = new Random();
        int i = random.nextInt(getGroupOrNull(Sender).getMembers().toArray().length );
        NormalMember member = (NormalMember) getGroupOrNull(Sender).getMembers().toArray()[i];
        final String MemberName = member.getNameCard();
        if(member == null)
        {
         Sender.sendMessage("获取失败");
        }
        else if(i != 0){
            try {
                member.kick("恭喜", false);
                Sender.sendMessage("有个B被踢了,他是:" + MemberName );
            } catch (Exception ex) {
                Sender.sendMessage("踏马的，肯定是随机到权限狗了,再来一次吧");
            }
        }
        else
        {
            Sender.sendMessage("随机到群主了,权限不够踢不了呀");
        }
    }


}
