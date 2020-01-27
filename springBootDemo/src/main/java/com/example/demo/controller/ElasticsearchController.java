package com.example.demo.controller;

import com.example.demo.javabean.ElasticsearchBean;
import com.example.demo.service.ElasticsearchService;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author young
 * @create 2020-01-14 11:28
 */

@RestController
public class ElasticsearchController {
    @Autowired
    ElasticsearchService elasticsearchService;
    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @GetMapping("/es1")
    @ResponseBody
    public void save1() {
        elasticsearchTemplate.createIndex("book");
        elasticsearchTemplate.createIndex(ElasticsearchBean.class);

    }
    @GetMapping("/es2")
    @ResponseBody
    public void save2() {
        ElasticsearchBean elasticsearchBean=new ElasticsearchBean();
        elasticsearchBean.setId("3");
        elasticsearchBean.setTitle("zjj ");
        elasticsearchBean.setContent("young19951006");
        elasticsearchBean.setState("1");
        IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(elasticsearchBean.getId())
                .withObject(elasticsearchBean)
                .build();
        elasticsearchTemplate.index(indexQuery);
    }

    @GetMapping("/es3")
    @ResponseBody
    public void search() {


        System.out.println("save3");
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.queryStringQuery("young"))
                .build();
        List<ElasticsearchBean> list = elasticsearchTemplate.queryForList(searchQuery, ElasticsearchBean.class);

        for (ElasticsearchBean elasticsearchBean : list) {

            System.out.println(elasticsearchBean);
        }

    }



    @GetMapping("/es")
    @ResponseBody
    public void save() {
        ElasticsearchBean elasticsearchBean=new ElasticsearchBean();
        elasticsearchBean.setId("3");
        elasticsearchBean.setTitle("young ");
        elasticsearchBean.setContent("彭阳彭阳");
        elasticsearchBean.setState("1");
        elasticsearchService.save(elasticsearchBean);

    }
}
