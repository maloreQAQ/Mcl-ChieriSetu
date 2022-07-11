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
                PlainText text = new PlainText("我超，你不是插件作者吗。你肯定又在冲吧，别冲了");
                Face smile = new Face(104);
                String ImageURL = "http://f0.0sm.com/node0/2022/07/862CC636B3ECDF6E-71086aa51d5666e5.jpg"; //发送的图像链接
                Image image = null;
                try {
                    image = ExternalResource.uploadAsImage(new URL(ImageURL).openConnection().getInputStream(), event.getSubject());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                MessageChain chain = new MessageChainBuilder()
                        .append(text)
                        .append(smile)
                        .append(image)
                        .build();
                event.getSubject().sendMessage(chain);
            }
        });
    }
}
