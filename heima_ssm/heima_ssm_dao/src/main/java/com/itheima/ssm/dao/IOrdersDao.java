package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;



public interface IOrdersDao extends JpaRepository<Orders, String>, JpaSpecificationExecutor<Orders> {

}
