package com.chieri.EroImage;
import com.chieri.config.config;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.*;
import net.mamoe.mirai.utils.ExternalResource;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
public class EroImage {
    String SeTuWords;
    public EroImage() throws Exception {
        config EConfig = new config();
        SeTuWords = EConfig.configJson().getString("SeTuWords");
        if (EConfig.configJson().getBoolean("SeTuSwitch"))
        {
            //监听事件
            GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class,(event) -> {
                String content = event.getMessage().contentToString();
                //判断

                if(content.startsWith(SeTuWords)){
                    EroJson js = new EroJson();
                    PlainText text = new PlainText("涩图给你，别冲太多哦~");
                    Face smile = new Face(103);
                    Image image = null;

                    try {
                        image = ExternalResource.uploadAsImage(new URL(js.getUrl()).openConnection().getInputStream(), event.getSubject());
                    } catch (Exception e) {
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
}
