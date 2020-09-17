package com.cjean.zoo.net.https;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * 重写createSocket方法，设置算法套
 */
public class MySSLSocketFactory extends SSLSocketFactory {
    private static final String[] cipherSuites = new String[]{
            "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
            "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256"};

    private static SSLContext sslContext = null;

    // 设置算法套
    private void setSSLParams(SSLSocket sslSocket) {
        sslSocket.setUseClientMode(true);
        sslSocket.setEnabledCipherSuites(cipherSuites);
    }

    /**
     * 创建SSLContext对象，使用默认信任管理器初始化
     */
    private static SSLContext getSslContext() {
        if (sslContext == null) {
            try {
                sslContext = SSLContext.getInstance("TLSv1.2");
                sslContext.init(new KeyManager[0], new TrustManager[]{new DefaultTrustManager()}, new SecureRandom());
            } catch (NoSuchAlgorithmException | KeyManagementException e) {
                e.printStackTrace();
            }
            SSLContext.setDefault(sslContext);
        }
        return sslContext;
    }

    @Override
    public String[] getDefaultCipherSuites() {
        return cipherSuites;
    }

    @Override
    public String[] getSupportedCipherSuites() {
        return cipherSuites;
    }

    @Override
    public Socket createSocket(Socket socket, String host, int port, boolean b) throws IOException {
        SSLSocket sslSocket = (SSLSocket) getSslContext().getSocketFactory().createSocket(socket, host, port, b);
        setSSLParams(sslSocket);
        return sslSocket;
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException {
        SSLSocket sslSocket = (SSLSocket) getSslContext().getSocketFactory().createSocket(host, port);
        setSSLParams(sslSocket);
        return sslSocket;
    }

    @Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException {
        SSLSocket sslSocket = (SSLSocket) getSslContext().getSocketFactory().createSocket(host, port, localHost, localPort);
        setSSLParams(sslSocket);
        return sslSocket;
    }

    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        SSLSocket sslSocket = (SSLSocket) getSslContext().getSocketFactory().createSocket(host, port);
        setSSLParams(sslSocket);
        return sslSocket;
    }

    @Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
        SSLSocket sslSocket = (SSLSocket) getSslContext().getSocketFactory().createSocket(address, port, localAddress, localPort);
        setSSLParams(sslSocket);
        return sslSocket;
    }


    /**
     * SSL信任管理类
     */
    private static class DefaultTrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

    }

}