package com.cjean.zoo.net.http;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class CreateHttp {

    public static void sendPost() {

        HttpClient httpClient;
        HttpPost postMethod;
        HttpResponse response;
        String reponseContent = null;
        try {
            httpClient = HttpClients.createDefault();
            postMethod = new HttpPost("http://192.168.0.227/v2/frs/user/apps/");
            //postMethod.addHeader("Content-type", "application/json; charset=utf-8");
            //设置请求头
            postMethod.addHeader("Content-type", "text/plain;charset=utf-8");
            postMethod.addHeader("accept", "*/*");
            postMethod.addHeader("connection", "Keep-Alive");
//            postMethod.addHeader("sign", sign);
//            postMethod.addHeader("timeStamp", timeStamp);
            postMethod.addHeader("Cookie", "sessionID=2140668503");

            //传递参数为json数据
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "5rWL6K+VM+W6kw==");
            jsonObject.put("threshold_value", 45);
            jsonObject.put("enable", 0);
            jsonObject.put("lib_type", 0);
            jsonObject.put("remark", "5o6l5Y+j5Yib5bu65Lq66IS45bqTMw==");
            //创建指定内容和编码的字符串实体类
            StringEntity entity = new StringEntity(jsonObject.toString(), Consts.UTF_8);
            //在post请求的 bady 中存放 json参数
            postMethod.setEntity(entity);
            response = httpClient.execute(postMethod);
            HttpEntity httpEntity = response.getEntity();
            reponseContent = EntityUtils.toString(httpEntity);
            EntityUtils.consume(httpEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("-----------------------");
        System.out.println(reponseContent);
        System.out.println("-----------------------");
    }

    public static void AccountCenter() throws Exception {
        HttpClient httpClient;
        HttpGet getMethod;
        HttpResponse response;
        String reponseContent;
        httpClient = HttpClients.createDefault();
//        getMethod = new HttpGet("http://192.168.0.227/v2/frs/user/apps/2/");
        getMethod = new HttpGet("http://zhaopin.kuaishou.cn/recruit/e/api/v1/open/positions/simple?pageNum=1&pageSize=600&positionCategoryCode=J0012&recruitProject=socialr");
        getMethod.addHeader("Content-type", "text/plain;charset=utf-8");
        getMethod.addHeader("accept", "*/*");
        getMethod.addHeader("connection", "Keep-Alive");
        getMethod.addHeader("Cookie", "sessionID=2140668503");

//        getMethod.addHeader("Authorization", "Bearer " + Authorization);
        response = httpClient.execute(getMethod);
        HttpEntity httpEntity = response.getEntity();
        reponseContent = EntityUtils.toString(httpEntity);
        EntityUtils.consume(httpEntity);
//        System.out.println("-----------打印返回的 json 数据------------");
//        System.out.println(reponseContent);
//        System.out.println("-----------打印结束------------");



    }

    public static void main(String[] args) throws Exception {




        AccountCenter();
//        sendPost();
    }

}