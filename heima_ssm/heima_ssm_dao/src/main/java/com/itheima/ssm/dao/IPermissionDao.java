package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface IPermissionDao extends JpaRepository<Permission, String>, JpaSpecificationExecutor<Permission> {

}
