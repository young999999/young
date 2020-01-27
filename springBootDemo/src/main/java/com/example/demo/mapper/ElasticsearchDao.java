package com.example.demo.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.javabean.ElasticsearchBean;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author young
 * @create 2020-01-14 11:28
 */

public interface ElasticsearchDao extends ElasticsearchRepository<ElasticsearchBean, String> {

}
