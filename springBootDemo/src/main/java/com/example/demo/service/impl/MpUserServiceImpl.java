package com.example.demo.service.impl;

import com.example.demo.javabean.MpUser;
import com.example.demo.mapper.MpUserMapper;
import com.example.demo.service.IMpUserService;
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
public class MpUserServiceImpl extends ServiceImpl<MpUserMapper, MpUser> implements IMpUserService {

}
