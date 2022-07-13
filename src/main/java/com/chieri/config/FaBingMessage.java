package com.chieri.config;

import net.mamoe.mirai.message.data.*;

public class FaBingMessage {
    public MessageChain getFaBingMessage(long targetID){
        MessageChain chain = new MessageChainBuilder()
                .append(new At(targetID))
                .append(new PlainText("我真的好喜欢你啊，我早上对着"))
                .append(new At(targetID))
                .append(new PlainText("冲，我晚上还在冲，"))
                .append(new Face(2))
                .append(new At(targetID))
                .append(new PlainText("为了你，我变成狼人模样"))
                .append(new Face(2))
                .append(new At(targetID))
                .append(new PlainText("为了你，燃烧了疯狂"))
                .append(new Face(2))
                .build();
        return chain;
    }
}
