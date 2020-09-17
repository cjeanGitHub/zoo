package com.cjean.zoo.net.https;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/**
 * 基于HttpsURLConnection实现客户端https请求
 *
 */
public class HttpsClientDemo {
    private static final String METHOD_GET = "GET";
    private static final String METHOD_POST = "POST";

    /**
     * doGet
     */
    private static void httpsGet(String url) throws NoSuchAlgorithmException, KeyManagementException, IOException {
        // 创建连接对象
        HttpsURLConnection connection = getHttpsURLConnection(url, METHOD_GET);
        connection.connect();
        System.out.println("cipersuit used:" + connection.getCipherSuite());

        // 读取连接响应内容
        getresponse(connection);
    }

    /**
     * doPost
     */
    private static void httpsPost(String url, String params) throws NoSuchAlgorithmException, IOException, KeyManagementException {
        // 创建连接对象
        HttpsURLConnection connection = getHttpsURLConnection(url, METHOD_POST);
        // 发送POST请求必须设置如下两行
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.connect();


        // 获取URLConnection对象对应的输出流
        PrintWriter out = null;
        try {
            out = new PrintWriter(connection.getOutputStream());
            // 发送请求参数
            out.print(params);
            out.flush();
        } finally {
            if (out != null) {
                out.close();
            }
        }
        getresponse(connection);
    }

    /**
     * 读取连接响应内容
     */
    private static void getresponse(HttpsURLConnection connection) throws IOException {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String inputLine;
            StringBuilder sb = new StringBuilder();
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }

            System.out.println("响应内容....");
            System.out.println(sb.toString());
            System.out.println("responseMsg:   " + connection.getResponseMessage() + "; responseCode:   " + connection.getResponseCode());
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    /**
     * 获取连接对象
     */
    private static HttpsURLConnection getHttpsURLConnection(String url, String method) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        URL myUrl = new URL(url);
        // 创建连接对象
        HttpsURLConnection connection = (HttpsURLConnection) myUrl.openConnection();
        connection.setRequestMethod(method);
        // 设置SSLSocketFactory对象（若不指定算法套，getSslContext().getSocketFactory()即可）
        connection.setSSLSocketFactory(new MySSLSocketFactory());
        // 验证hostname,全部允许
        connection.setHostnameVerifier((hostname, sslSession) -> true);

        // 设置通用请求属性
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.84 Safari/537.36");
        connection.setRequestProperty("Connection", "Keep-Alive");
        connection.setRequestProperty("Charset", "UTF-8");
        connection.setRequestProperty("Cookie", "sessionID=2140668503");


        return connection;
    }

    public static void main(String[] args) throws Exception {
//        String url = "https://www.baidu.com/home/msg/data/personalcontent?num=8&indextype=manht&_req_seqid=0xaeb5ca8f000e4c75&asyn=1&t=1597369139004&sid=";
//        String url = "https://192.168.0.227/v2/frs/user/apps/2/";
        String url = "https://192.168.0.227/v2/frs/user/apps/";
//        httpsGet(url);

        httpsPost(url, "name=5rWL6K+VNeW6kw==&threshold_value=45&enable=0&lib_type=0&remark=88888");
    }
}

