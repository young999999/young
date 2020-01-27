package com.example.demo.controller;

import com.example.demo.bean.ElasticsearchBean;
import com.example.demo.dao.ElasticsearchDao;
import com.example.demo.sercice.ElasticsearchService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author young
 * @create 2020-01-14 11:28
 */
@SpringBootTest
@Controller
public class ElasticsearchController {
    @Autowired
    ElasticsearchService elasticsearchService;

    @Test
    @GetMapping("/es")
    public void save() {
        ElasticsearchBean elasticsearchBean=new ElasticsearchBean();
//        ElasticsearchService elasticsearchService=new ElasticsearchService();
        elasticsearchBean.setId("1");
        elasticsearchBean.setTitle("zj");
        elasticsearchBean.setContent("young");
        elasticsearchBean.setState("1");
        elasticsearchService.save(elasticsearchBean);
    }
}
