package com.chieri;

import com.chieri.AuthorEggs.AuthorEggs;
import com.chieri.EroImage.EroImage;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;

public final class Plugin extends JavaPlugin {
    public static final Plugin INSTANCE = new Plugin();

    private Plugin() {

        super(
                new JvmPluginDescriptionBuilder(
                        "com.chieri.plugin",
                        "1.0"
                )
                .author("Chieeri")
                .name("☆Chieri涩图插件☆")
                .info("=============正在加载================")
                .build()
        );
    }

    @Override
    public void onEnable() {

        getLogger().info("============插件加载成功!=============");
        // 作者彩蛋嘻嘻
        AuthorEggs Egg = new AuthorEggs(); //作者彩蛋加载

        try {
            EroImage Ero = new EroImage(); //涩图功能加载
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}