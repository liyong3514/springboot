package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IRoleDao extends JpaRepository<Role, String>, JpaSpecificationExecutor<Role> {
    @Query(value = "select * from permission where id not in (select permissionId from role_permission where roleId=?1)",nativeQuery = true)
    List<Permission> findOtherPermissions(String roleId);
}
