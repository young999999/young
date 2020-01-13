package com.example.demo.service.impl;

import com.example.demo.javabean.Tags;
import com.example.demo.mapper.TagsMapper;
import com.example.demo.service.ITagsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author young
 * @since 2020-01-03
 */
@Service
public class TagsServiceImpl extends ServiceImpl<TagsMapper, Tags> implements ITagsService {

}
