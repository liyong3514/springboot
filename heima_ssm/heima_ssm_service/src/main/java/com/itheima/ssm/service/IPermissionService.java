package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;

import java.util.List;

/**
 * @Author 李永
 * @Description
 * @Date  2019\1\5 0005
 * @version 1.0
*/
public interface IPermissionService {

    /**
     * 
     * @return
     * @throws Exception
     */
    public List<Permission> findAll() throws Exception;

    /**
     * 
     * @param permission
     * @throws Exception
     */
    void save(Permission permission) throws Exception;

    /**
     * 
     * @param id
     * @return
     * @throws Exception
     */
    Permission findById(String id) throws Exception;

    /**
     * 
     * @param id
     * @throws Exception
     */
    void deleteById(String id) throws Exception;
}
