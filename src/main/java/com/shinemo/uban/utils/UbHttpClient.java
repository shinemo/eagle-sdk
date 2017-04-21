package com.shinemo.uban.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * User: luchao
 * Mail: luc@shinemo.com
 * Date: 2017/4/12
 * Time: 18:07
 */
public class UbHttpClient {
    public static final CloseableHttpClient httpClient = instanceHttpClient();
    private static final Logger log = LoggerFactory.getLogger(UbHttpClient.class);
    private static final int DEFAULT_CONNECT_TIMEOUT = 3000;
    private static final int DEFAULT_SO_TIMEOUT = 3000;
    private static final int HTTP_SUCCESS_CODE = 200;

    public UbHttpClient() {
    }

    private static final RequestConfig getRequestConfig(int socketTimeout) {
        return RequestConfig.custom().setConnectTimeout(3000).setSocketTimeout(socketTimeout <= 0 ? 3000 : socketTimeout).setRedirectsEnabled(true).build();
    }

    public static void addHttpHeader(Object object, Map<String, String> headMap) {
        if (null != headMap && headMap.size() > 0) {
            Iterator response = headMap.entrySet().iterator();
            while (response.hasNext()) {
                Map.Entry result = (Map.Entry) response.next();
                if (object instanceof HttpPost)
                    ((HttpPost) object).addHeader((String) result.getKey(), (String) result.getValue());
                if (object instanceof HttpDelete)
                    ((HttpDelete) object).addHeader((String) result.getKey(), (String) result.getValue());
                if (object instanceof HttpGet)
                    ((HttpGet) object).addHeader((String) result.getKey(), (String) result.getValue());
            }
        }
    }

    public static String GetRequest(String url, Map<String, String> headMap) throws Exception {
        return GetRequest(url, headMap, 10000);
    }

    public static String GetRequest(String url, Map<String, String> headMap, int socketTimeoutMills) throws Exception {
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Content-Type", "text/plain");
        httpGet.setConfig(getRequestConfig(socketTimeoutMills));
        addHttpHeader(httpGet,headMap);

        CloseableHttpResponse response1 = httpClient.execute(httpGet);
        String result1 = UbIOUtils.getStringFromInputStream(response1.getEntity().getContent());
        if (response1.getStatusLine().getStatusCode() != 200) {
            log.error("GetRequest fail,req_url:{},req_head:{},rsp_status:{},rsp_result:{},timeout:{}", new Object[]{url, UbJsonUtils.toJson(headMap), Integer.valueOf(response1.getStatusLine().getStatusCode()), result1, Integer.valueOf(socketTimeoutMills)});
            throw new Exception("getStatusCode() != 200,statusCode:" + response1.getStatusLine().getStatusCode() + ",url:" + url);
        } else {
            return result1;
        }
    }

    public static String PostTextRequest(String url, Map<String, String> headMap, String content) throws Exception {
        return PostTextRequest(url, headMap, content, 10000);
    }

    public static String PostTextRequest(String url, Map<String, String> headMap, String content, int socketTimeoutMills) throws Exception {
        return PostRequest(url, headMap, content, socketTimeoutMills, "text/plain;charset=UTF-8");
    }

    public static String PostJsonRequest(String url, Map<String, String> headMap, String content) throws Exception {
        return PostRequest(url, headMap, content, 10000, (String) null);
    }

    public static String PostJsonRequest(String url, Map<String, String> headMap, String content, int socketTimeoutMills) throws Exception {
        return PostRequest(url, headMap, content, socketTimeoutMills, (String) null);
    }


    public static String PostRequest(String url, Map<String, String> headMap, String content, int socketTimeoutMills, String contentType) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        if (StringUtils.isBlank(contentType)) {
            contentType = "application/json;charset=UTF-8";
        }
        httpPost.addHeader("Content-Type", contentType);
        httpPost.setConfig(getRequestConfig(socketTimeoutMills));
        addHttpHeader(httpPost, headMap);

        if (StringUtils.isNotBlank(content)) {
            httpPost.setEntity(new StringEntity(content, "UTF-8"));
        }

        CloseableHttpResponse response1 = httpClient.execute(httpPost);
        String result1 = UbIOUtils.getStringFromInputStream(response1.getEntity().getContent());
        if (response1.getStatusLine().getStatusCode() != 200) {
            log.error("PostTextRequest fail,req_url:{},content:{},req_head:{},rsp_status:{},rsp_result:{},timeout:{}", new Object[]{url, content, UbJsonUtils.toJson(headMap), Integer.valueOf(response1.getStatusLine().getStatusCode()), result1, Integer.valueOf(socketTimeoutMills)});
            throw new Exception("getStatusCode() != 200,statusCode:" + response1.getStatusLine().getStatusCode() + ",url:" + url);
        } else {
            return result1;
        }
    }

    public static String PostBytesRequest(String url, Map<String, String> headMap, byte[] content) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        if (headMap != null) {
            Iterator response = headMap.entrySet().iterator();

            while (response.hasNext()) {
                Map.Entry result = (Map.Entry) response.next();
                httpPost.addHeader((String) result.getKey(), (String) result.getValue());
            }
        }

        if (null != content) {
            httpPost.setEntity(new ByteArrayEntity(content));
        }

        CloseableHttpResponse response1 = httpClient.execute(httpPost);
        String result1 = UbIOUtils.getStringFromInputStream(response1.getEntity().getContent());
        if (response1.getStatusLine().getStatusCode() != 200) {
            log.error("PostBytesRequest fail,req_url:{},req_head:{},rsp_status:{},rsp_result:{}", new Object[]{url, UbJsonUtils.toJson(headMap), Integer.valueOf(response1.getStatusLine().getStatusCode()), result1});
            throw new Exception("getStatusCode() != 200,statusCode:" + response1.getStatusLine().getStatusCode() + ",url:" + url);
        } else {
            return result1;
        }
    }

    public static String PostFormRequest(String url, Map<String, String> headMap, Map<String, String> content) throws Exception {
        return PostFormRequest(url, headMap, content, 10000);
    }

    public static String PostFormRequest(String url, Map<String, String> headMap, Map<String, String> content, int socketTimeoutMills) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(getRequestConfig(socketTimeoutMills));
        addHttpHeader(httpPost, headMap);

        if (content != null) {
            ArrayList response1 = new ArrayList();
            Iterator result1 = content.entrySet().iterator();

            while (result1.hasNext()) {
                Map.Entry entry = (Map.Entry) result1.next();
                response1.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
            }

            httpPost.setEntity(new UrlEncodedFormEntity(response1, Charset.forName("UTF-8")));
        }

        CloseableHttpResponse response2 = httpClient.execute(httpPost);
        String result2 = UbIOUtils.getStringFromInputStream(response2.getEntity().getContent());
        if (response2.getStatusLine().getStatusCode() != 200) {
            log.error("PostFormRequest fail,req_url:{},req_head:{},req_content:{},rsp_status:{},rsp_result:{},timeout:{}", new Object[]{url, UbJsonUtils.toJson(headMap), UbJsonUtils.toJson(content), Integer.valueOf(response2.getStatusLine().getStatusCode()), result2, Integer.valueOf(socketTimeoutMills)});
            throw new Exception("getStatusCode() != 200,statusCode:" + response2.getStatusLine().getStatusCode() + ",url:" + url);
        } else {
            return result2;
        }
    }

    public static String DeleteRequest(String url, Map<String, String> headMap) throws Exception {
        return DeleteRequest(url, headMap, 10000);
    }

    public static String DeleteRequest(String url, Map<String, String> headMap, int socketTimeoutMills) throws Exception {
        HttpDelete httpDelete = new HttpDelete(url);
        httpDelete.addHeader("Content-Type", "text/plain");
        httpDelete.setConfig(getRequestConfig(socketTimeoutMills));
        addHttpHeader(httpDelete, headMap);

        CloseableHttpResponse response1 = httpClient.execute(httpDelete);
        String result1 = UbIOUtils.getStringFromInputStream(response1.getEntity().getContent());
        if (response1.getStatusLine().getStatusCode() != 200) {
            log.error("DeleteRequest fail,req_url:{},req_head:{},rsp_status:{},rsp_result:{},timeout:{}", new Object[]{url, UbJsonUtils.toJson(headMap), Integer.valueOf(response1.getStatusLine().getStatusCode()), result1, Integer.valueOf(socketTimeoutMills)});
            throw new Exception("getStatusCode() != 200,statusCode:" + response1.getStatusLine().getStatusCode() + ",url:" + url);
        } else {
            return result1;
        }
    }

    public static String postStreamRequest(String url, Map<String, String> headMap, InputStream content, String type, int socketTimeoutMills) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "text/plain");
        httpPost.setConfig(getRequestConfig(socketTimeoutMills));
        addHttpHeader(httpPost,headMap);

        httpPost.setEntity(new InputStreamEntity(content));
        CloseableHttpResponse response1 = httpClient.execute(httpPost);
        if (response1.getStatusLine().getStatusCode() != 200) {
            throw new Exception("getStatusCode() != 200,statusCode:" + response1.getStatusLine().getStatusCode() + ",url:" + url);
        } else {
            return UbIOUtils.getStringFromInputStream(response1.getEntity().getContent());
        }
    }

    public static CloseableHttpClient instanceHttpClient() {
        Registry registry = RegistryBuilder.create().register("http", PlainConnectionSocketFactory.INSTANCE).register("https", UbHttpClient.SSLFactory.factory).build();
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);
        return HttpClients.custom().setConnectionManager(connectionManager).build();
    }

    static class SSLFactory {
        public static SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(getTrustAllContext());

        SSLFactory() {
        }

        public static SSLContext getTrustAllContext() {
            SSLContext sslContext = null;

            try {
                sslContext = SSLContext.getInstance("TLS");
                sslContext.init((KeyManager[]) null, new TrustManager[]{new UbHttpClient.SSLFactory.TrustAnyTrustManager()}, new SecureRandom());
                return sslContext;
            } catch (Exception var2) {
                throw new RuntimeException(var2);
            }
        }

        private static class TrustAnyTrustManager implements X509TrustManager {
            private TrustAnyTrustManager() {
            }

            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }
    }
}

