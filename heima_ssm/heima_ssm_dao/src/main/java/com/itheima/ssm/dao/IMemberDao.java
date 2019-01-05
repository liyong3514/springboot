package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IMemberDao extends JpaRepository<Member, String>, JpaSpecificationExecutor<Member> {


}
