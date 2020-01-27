package com.spider.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author young
 * @create 2020-01-18 16:09
 */
public class PageDownUtil {
    public static String getPageContent(String url) {
        HttpClientBuilder builder = HttpClients.custom();
        CloseableHttpClient client = builder.build();

        HttpGet request = new HttpGet(url);
        String content = null;
        try {
            CloseableHttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            content = EntityUtils.toString(entity);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            request.releaseConnection();
        }

        return content;
    }

    public static void main(String[] args) {
        String url ="https://v.youku.com/v_show/id_XNDQ5NjA0MTk1Ng==.html?spm=a2hcb.12523948.m_5295_c_12649.d_1&s=ecef33670f3044059de9&scm=20140719.manual.5295.show_ecef33670f3044059de9";
        String pageContent = getPageContent(url);
        System.err.println(pageContent);
    }
}
