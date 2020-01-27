package com.example.demo.service;


import com.example.demo.javabean.ElasticsearchBean;
import com.example.demo.mapper.ElasticsearchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author young
 * @create 2020-01-14 11:31
 */
@Service
public class ElasticsearchService {

    @Autowired
    ElasticsearchDao elasticsearchDao;

    public void save(ElasticsearchBean elasticsearchBean) {
        ElasticsearchBean save = elasticsearchDao.save(elasticsearchBean);

    }
}
