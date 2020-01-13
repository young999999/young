package com.example.demo.service.impl;

import com.example.demo.javabean.TblEmployee;
import com.example.demo.mapper.TblEmployeeMapper;
import com.example.demo.service.ITblEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author BaoZhou
 * @since 2020-01-03
 */
@Service
public class TblEmployeeServiceImpl extends ServiceImpl<TblEmployeeMapper, TblEmployee> implements ITblEmployeeService {

}
