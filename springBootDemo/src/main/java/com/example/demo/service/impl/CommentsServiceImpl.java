package com.example.demo.service.impl;

import com.example.demo.javabean.Comments;
import com.example.demo.mapper.CommentsMapper;
import com.example.demo.service.ICommentsService;
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
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements ICommentsService {

}
