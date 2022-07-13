package com.chieri.AuthorEggs;

import net.mamoe.mirai.contact.Contact;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.*;
import net.mamoe.mirai.utils.ExternalResource;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class AuthorEggs {
    public AuthorEggs(){
        GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class, (event) ->{
            if (event.getSender().getId() == 826517063 && event.getMessage().contentToString().startsWith("我是作者")) {
                PlainText text = new PlainText("（作者触发彩蛋）我超，你不是插件作者吗。你肯定又在冲吧，别冲了");
                Face smile = new Face(104);
                MessageChain chain = new MessageChainBuilder()
                        .append(text)
                        .append(smile)
                        .build();
                event.getSubject().sendMessage(chain);
            }
        });
    }
}