package com.spider.service;

import com.spider.entity.Movie;
import com.spider.entity.Page;

import java.util.List;

/**
 * @author young
 * @create 2020-01-18 18:41
 */
public interface IProcessService {
    public List processMovieList(Page page);
    public Movie processMovie(Page page);
    public boolean judgmentMovieListPage(Page page);

}
