package com.cjean.zoo.net.http;

import com.alibaba.fastjson.JSONObject;
import com.cjean.zoo.net.http.domain.LangChaoEmployee;
import com.cjean.zoo.net.http.domain.LangChaoPostionEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class GetLangChaoInfoFromHttpByPostMethod {

    public static String AccountCenter(String getUrl) throws Exception {
        HttpClient httpClient;
        HttpPost postMethod;
        HttpResponse response;
        String reponseContent;
        httpClient = HttpClients.createDefault();
        postMethod = new HttpPost(getUrl);

//        postMethod.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.106 Safari/537.36");
//        postMethod.addHeader("Accept-Encoding", "gzip, deflate, br\n" +
//                "Accept-Language: zh-CN,zh;q=0.9");
//        postMethod.addHeader("Content-type", "application/json;charset=UTF-8");
//        postMethod.addHeader("Accept", "application/json,text/plain,*/*");



        StringRequestEntity entity = new StringRequestEntity("page_size", "1", "utf-8");
//        post.setRequestEntity(entity);

        response = httpClient.execute(postMethod);
        HttpEntity httpEntity = response.getEntity();
        reponseContent = EntityUtils.toString(httpEntity);
        EntityUtils.consume(httpEntity);

        JSONObject jsonObject = JSONObject.parseObject(reponseContent);
        List<LangChaoPostionEntity> infos = new ArrayList<>();
        LangChaoPostionEntity langChaoPostionEntity = new LangChaoPostionEntity();
        LangChaoEmployee employee = new LangChaoEmployee();

//        if (!jsonObject.get("srv_begin").equals("")) {
//
//            JSONObject resultInfo = (JSONObject) jsonObject.get("result");
//            JSONArray list = JSON.parseArray(JSON.toJSONString(resultInfo.get("list")));
//            for (int i = 0; i < list.size(); i++) {
//                JSONObject o = (JSONObject)list.get(i);
//
//                langChaoPostionEntity.setId(o.get("id").toString());
//
//                langChaoPostionEntity.setName(DecodeSth.decodeUnicode(o.get("name").toString()));
//                langChaoPostionEntity.setJob_desc(DecodeSth.decodeUnicode(o.get("job_desc").toString()));
//
//                langChaoPostionEntity.setLow_salary(o.get("low_salary").toString());
//                langChaoPostionEntity.setLow_salary(o.get("high_salary").toString());
//                langChaoPostionEntity.setWork_province(DecodeSth.decodeUnicode(o.get("work_province").toString()));
//                langChaoPostionEntity.setWork_city(DecodeSth.decodeUnicode(o.get("work_city").toString()));
//                langChaoPostionEntity.setWork_address(DecodeSth.decodeUnicode(o.get("work_address").toString()));
//                langChaoPostionEntity.setVague_str(DecodeSth.decodeUnicode(o.get("vague_str").toString()));
//                langChaoPostionEntity.setEmail(o.get("email").toString());
//                langChaoPostionEntity.setAuto_offline_date(o.get("auto_offline_date").toString());
//
//                JSONObject emplyeeJS = (JSONObject) o.get("employee");
//                employee.setId(emplyeeJS.get("id").toString());
//                employee.setName(DecodeSth.decodeUnicode(emplyeeJS.get("name").toString()));
//                employee.setBirthday(emplyeeJS.get("birthday").toString());
//                employee.setNative_place(DecodeSth.decodeUnicode(emplyeeJS.get("native_place").toString()));
//                employee.setMarried(DecodeSth.decodeUnicode(emplyeeJS.get("married").toString()));
//                employee.setNation(DecodeSth.decodeUnicode(emplyeeJS.get("nation").toString()));
//                employee.setIdentity_card(emplyeeJS.get("identity_card").toString());
//                employee.setMobile(emplyeeJS.get("mobile").toString());
//                employee.setMail(emplyeeJS.get("mail").toString());
//                employee.setJob_level(emplyeeJS.get("job_level").toString());
//                langChaoPostionEntity.setLangChaoEmployee(employee);
//
//                infos.add(langChaoPostionEntity);
//
//
//            }
//
//        }

        System.out.println("-----------打印返回的 json 数据------------");
        System.out.println(reponseContent);
        System.out.println("-----------打印结束------------");

        return reponseContent;



        
    }

    public static void main(String[] args) throws Exception {

        String url = "https://inspur.hcmcloud.cn/api/recruit.get.jobs.detail_search";
        String data = AccountCenter(url);


    }

}