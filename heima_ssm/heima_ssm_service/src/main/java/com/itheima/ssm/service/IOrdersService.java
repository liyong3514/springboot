package com.itheima.ssm.service;

import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.domain.PageInfo;


public interface IOrdersService {


    PageInfo<Orders> findAll(int page, int size) throws Exception;

    Orders findById(String ordersId) throws Exception;
}
