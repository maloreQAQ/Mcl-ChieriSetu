package com.chieri.config;

import net.sf.json.JSONObject;

import java.io.*;

public class config {

    public config() throws Exception {
        File file = new File("./config/com.chieri/config.conf");
        if (!file.exists()){
            JSONObject config = new JSONObject();
            config.put("SeTuSwitch","true");
            config.put("SeTuWords","涩图");
            File dir = new File("./config/com.chieri");
            dir.mkdirs();
            FileOutputStream cop = new FileOutputStream(new File("./config/com.chieri/config.conf"));
            OutputStreamWriter copWriter = new OutputStreamWriter(cop,"UTF-8");
            copWriter.append(config.toString());
            copWriter.close();
            cop.close();
        }
        else{
            System.out.println("配置已加载");
        }

    }
    public JSONObject configJson() throws Exception {
        InputStream is = new FileInputStream(new File("./config/com.chieri/config.conf"));
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
        JSONObject js = JSONObject.fromObject(br.readLine());
        return js;
    }
}
