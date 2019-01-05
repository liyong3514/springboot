package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface IProductDao extends JpaRepository<Product, String>, JpaSpecificationExecutor<Product> {


}
