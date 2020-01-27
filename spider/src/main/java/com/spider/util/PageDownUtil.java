package com.spider.util;

import com.spider.entity.Movie;
import com.spider.entity.Page;
import com.spider.mapper.MovieMapper;
import com.spider.service.impl.HttpClientDownloadService;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * @author young
 * @create 2020-01-18 16:09
 */

public class PageDownUtil {
    public static String getPageContent(String url) {
        HttpClientBuilder builder = HttpClients.custom();
        builder.setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
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

    @Autowired
    static MovieMapper movieMapper;
    public static void main(String[] args) {
        Movie movie = movieMapper.selectById(1);
        System.err.println(movie);
//        String url ="https://api.123zx.net/?m=vod-index-pg-888.html";
//        HttpClientDownloadService httpClientDownloadService = new HttpClientDownloadService();
//        Page page=httpClientDownloadService.download(url);
//        System.err.println(page.getContent());
    }
}
