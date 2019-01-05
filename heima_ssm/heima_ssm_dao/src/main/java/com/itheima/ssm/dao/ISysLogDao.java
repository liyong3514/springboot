package com.itheima.ssm.dao;

import com.itheima.ssm.domain.SysLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface ISysLogDao extends JpaRepository<SysLog, String>, JpaSpecificationExecutor<SysLog> {

}
