package com.example.demo.sercice;

import com.example.demo.bean.ElasticsearchBean;
import com.example.demo.dao.ElasticsearchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author young
 * @create 2020-01-14 11:31
 */
@Service("elasticsearchService")
public class ElasticsearchService {
    @Autowired
    ElasticsearchDao elasticsearchDao;

    public void save(ElasticsearchBean elasticsearchBean) {
        System.out.println("123456");
        elasticsearchDao.save(elasticsearchBean);
    }
}
