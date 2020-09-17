package com.cjean.zoo.net.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cjean.exercise.exercise01.net.http.domain.KuaiShouPostionEntity;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class GetInfoFromHttpByGetMethod {

    public static String AccountCenter(String getUrl) throws Exception {
        HttpClient httpClient;
        HttpGet getMethod;
        HttpResponse response;
        String reponseContent;
        httpClient = HttpClients.createDefault();
        getMethod = new HttpGet(getUrl);

        getMethod.addHeader("Host", "zhaopin.kuaishou.cn");
        getMethod.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.106 Safari/537.36");
        getMethod.addHeader("Sec-Fetch-Site", "same-origin");
        getMethod.addHeader("Sec-Fetch-Mode", "cors");
        getMethod.addHeader("Sec-Fetch-Dest", "empty");
        getMethod.addHeader("Referer", "http://zhaopin.kuaishou.cn/recruit/e/");
        getMethod.addHeader("Accept-Encoding", "gzip, deflate, br\n" +
                "Accept-Language: zh-CN,zh;q=0.9");
//        getMethod.addHeader("Host", "");
        getMethod.addHeader("Content-type", "application/json;charset=UTF-8");
        getMethod.addHeader("Cache-Control", "no-cache");
        getMethod.addHeader("Content-Encoding", "gzip");
        getMethod.addHeader("Content-Security-Policy", "default-src 'self' *.gifshow.com *.kuaishou.com *.kuaishou.cn *.yximgs.com *.ksapisrv.com fonts.gstatic.com campus.kuaishou.cn:* http://campus.kuaishou.cn:* hm.baidu.com p.qpic.cn p.qlogo.cn at.alicdn.com s3-us-west-2.amazonaws.com data: blob: android-webview-video-poster:;style-src 'unsafe-inline' *.gifshow.com *.kuaishou.com http://*.yximgs.com https://*.yximgs.com *.kuaishou.cn data:;connect-src *.ksapisrv.com hm.baidu.com 'self' *.gifshow.com *.kuaishou.com *.kuaishou.cn http://zhaopin.kuaishou.cn blob: data:;script-src 'unsafe-eval' 'unsafe-inline' 'self' *.gifshow.com *.kuaishou.com *.yximgs.com *.kuaishou.cn hm.baidu.com at.alicdn.com;form-action 'self' *.ksapisrv.com;report-uri https://csplog.kuaishou.com/log/zhaopin");
        getMethod.addHeader("Content-Security-Policy", "upgrade-insecure-requests");
//        System.out.println(new Date().toString());
        getMethod.addHeader("Date", new Date().toString());
        getMethod.addHeader("Expires", "0");

//        getMethod.addHeader("Pragma ", "no-cache");
//        getMethod.addHeader("Server  ", "openresty");
//        getMethod.addHeader("Transfer-Encoding ", "chunked");

        getMethod.addHeader("Vary", "Accept-Encoding");
        getMethod.addHeader("X-Content-Type-Options", "nosniff");
        getMethod.addHeader("X-Xss-Protection", "1;mode=block");
        getMethod.addHeader("Accept", "application/json,text/plain,*/*");
        getMethod.addHeader("connection", "Keep-Alive");
        getMethod.addHeader("Cookie", "__secdyid=253a22269da878e1b15343faefa53fcd7180bb3a5f1b2349021598076809;accessproxy_session=28d73296-f971-4b6e-95c4-d393ec2b6f9c");

//        getMethod.addHeader("Authorization", "Bearer " + Authorization);
        response = httpClient.execute(getMethod);
        HttpEntity httpEntity = response.getEntity();
        reponseContent = EntityUtils.toString(httpEntity);
        EntityUtils.consume(httpEntity);

//        System.out.println("-----------打印返回的 json 数据------------");
//        System.out.println(reponseContent);
//        System.out.println("-----------打印结束------------");

        return reponseContent;



        
    }

    public static void main(String[] args) throws Exception {

//        String url = "http://zhaopin.kuaishou.cn/recruit/e/api/v1/open/positions/simple?name=java&pageNum=1&pageSize=100&recruitProject=socialr";
        String url = "https://zhaopin.kuaishou.cn/recruit/e/api/v1/open/positions/simple?name=&pageNum=1&pageSize=1400&recruitProject=socialr";
        String data = AccountCenter(url);

        JSONObject jsonObject = JSONObject.parseObject(data);
        List<KuaiShouPostionEntity> infos = new ArrayList<>();

        if (jsonObject.get("message").equals("ok")) {

            JSONObject resultInfo = (JSONObject) jsonObject.get("result");
            Object total = resultInfo.get("total");
            System.out.println("total:  "+total);
            infos.addAll(JSON.parseArray(JSON.toJSONString(resultInfo.get("list")), KuaiShouPostionEntity.class));

        }

        System.out.println("----开始-------------------");
        infos = infos.stream().filter(info->{
            return info.getWorkLocationCode().equals("Jinan");
        }).map(info->{
            String workExperienceCode = info.getWorkExperienceCode();
            switch (workExperienceCode){
                case "7":
                    info.setWorkExperienceCode("10年以上");
                    break;
                case "6":
                    info.setWorkExperienceCode("5~10年");
                    break;
                case "5":
                    info.setWorkExperienceCode("3~5年以上");
                    break;
                case "4":
                    info.setWorkExperienceCode("1~3年以上");
                    break;
                case "1":
                    info.setWorkExperienceCode("不限");
                    break;
            }
            String workLocationCode = info.getWorkLocationCode();
            switch (workLocationCode){
                case "Shenzhen":
                    info.setWorkLocationCode("深圳");
                    break;
                case "Hangzhou":
                    info.setWorkLocationCode("杭州");
                    break;
                case "Beijing":
                    info.setWorkLocationCode("北京");
                    break;
                case "Jinan":
                    info.setWorkLocationCode("济南");
                    break;
                case "1":
                    info.setWorkLocationCode("不限");
                    break;
            }


            return info;
        }).collect(Collectors.toList());


        String sring = JSONObject.toJSON(infos).toString();
        System.out.println(sring);


        System.out.println("----结束-------------------");


    }

}