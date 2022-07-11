package com.chieri.EroImage;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class EroJson {
    public String getUrl() throws Exception {
        //打开url并获取JSON数据
        URL url = new URL("http://api.iw233.cn/api.php?sort=cat&type=json");
        InputStream is = url.openStream();
        BufferedReader ero = new BufferedReader(new InputStreamReader(is));
        String EroUrl = ero.readLine();
        //解析JSON数据
        JSONObject EroJSon = JSONObject.fromObject(EroUrl);
        JSONArray jsonEroArray = EroJSon.getJSONArray("pic");
        String urlEro = jsonEroArray.getString(0);
        return urlEro;
    }
}
