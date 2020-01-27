package com.spider.service.impl;

import com.spider.entity.Page;
import com.spider.service.IDownLoadService;
import com.spider.util.PageDownUtil;

/**
 * @author young
 * @create 2020-01-18 18:18
 */
public class HttpClientDownloadService implements IDownLoadService {
    @Override
    public Page download(String url) {
        Page page = new Page();
        page.setContent(PageDownUtil.getPageContent(url));

        return page;
    }
}
