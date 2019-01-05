package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Traveller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface ITravellerDao extends JpaRepository<Traveller, String>, JpaSpecificationExecutor<Traveller> {

}
