package com.itheima.ssm.dao;


import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IUserDao extends JpaRepository<UserInfo, String>, JpaSpecificationExecutor<UserInfo> {

    @Query(value = "select * from role where id not in (select roleId from users_role where userId=?1)",nativeQuery = true)
    List<Role> findOtherRoles(String userId);

    UserInfo findByUsername(String username);
}
