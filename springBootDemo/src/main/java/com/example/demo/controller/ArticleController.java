package com.example.demo.controller;


import com.example.demo.javabean.Article;
import com.example.demo.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author young
 * @since 2020-01-03
 */
@Controller
@RequestMapping("/article")
//@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
public class ArticleController {
    @Autowired
    IArticleService articleService;


//    @PostMapping("/article1")//搭配@RequestParam；http://localhost:8087/article/article1?id=109
    @GetMapping("/article1")//搭配@RequestParam；http://localhost:8087/article/article1?id=109
//    @GetMapping("/article1/{id}")//搭配@PathVariable("id")；http://localhost:8087/article/article1/109
    @ResponseBody
//    public Article test2(@RequestBody Article id) {
    public Article test2(/*@PathVariable("id")*//*@RequestParam*/ Integer id,/*@RequestParam*/ String name) {

        System.err.println(id+" "+name);
//        System.out.println(id+" ");
//        System.err.println(articleService.getById(id));
        Article article = articleService.getById(id);
        return article;

    }
}

