package com.spider.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spider.entity.Movie;
import com.spider.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author young
 * @create 2020-01-27 11:18
 */

@RestController
@CrossOrigin
public class MovieController {
    @Autowired
    MovieMapper movieMapper;

    @GetMapping("movie/{name}")
    @ResponseBody
    public Movie getMovie(@PathVariable String name){

        Movie movie = movieMapper.findByMovieName(name);

        return movie;
    }
}
