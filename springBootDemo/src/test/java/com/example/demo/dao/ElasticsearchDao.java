package com.example.demo.dao;

import com.example.demo.bean.ElasticsearchBean;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author young
 * @create 2020-01-14 11:28
 */
@Repository
public interface ElasticsearchDao extends ElasticsearchRepository<ElasticsearchBean, String> {
    void sava(ElasticsearchBean elasticsearchBean);
}
