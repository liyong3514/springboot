package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IOrdersDao;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.domain.PageInfo;
import com.itheima.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public PageInfo<Orders> findAll(int page, int size) throws Exception {

        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Orders> pages = ordersDao.findAll(pageable);

        return  new PageInfo<>(page,size,pages.getTotalPages(),pages.getContent(), pages.getTotalElements());
    }

    @Override
    public Orders findById(String ordersId) throws Exception{
        return ordersDao.findById(ordersId).get();
    }
}
