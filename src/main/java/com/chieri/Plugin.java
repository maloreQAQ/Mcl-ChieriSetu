package com.chieri;

import com.chieri.AuthorEggs.AuthorEggs;
import com.chieri.EroImage.EroImage;
import com.chieri.command.OrderFaBing;
import com.chieri.command.RandomFaBing;
import com.chieri.command.kick;
import net.mamoe.mirai.console.command.CommandManager;
import net.mamoe.mirai.console.permission.AbstractPermitteeId;
import net.mamoe.mirai.console.permission.PermissionService;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;

public final class Plugin extends JavaPlugin {
    public static final Plugin INSTANCE = new Plugin();

    private Plugin() {

        super(
                new JvmPluginDescriptionBuilder(
                        "com.chieri.plugin",
                        "1.3.1"
                )
                .author("Chieeri")
                .name("☆Chieri涩涩插件☆")
                .info("当前版本为ver 1.3.1哦")
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

        //注册指令
        CommandManager.INSTANCE.registerCommand(new kick(),true);
        CommandManager.INSTANCE.registerCommand(new RandomFaBing(),true);
        CommandManager.INSTANCE.registerCommand(new OrderFaBing(),true);
    }
}