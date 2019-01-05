package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IPermissionDao;
import com.itheima.ssm.dao.IRoleDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public void deleteRoleById(String roleId) {
        //从user_role表中删除
        roleDao.deleteById(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {
        Role role = new Role();
        role.setId(roleId);
        for (String permissionId : permissionIds) {
            Permission permission = new Permission();
            permission.setId(permissionId);
            role.getPermissions().add(permission);
        }
        roleDao.save(role);
    }

    @Override
    public Role findById(String roleId) {
        return roleDao.findById(roleId).get();
    }

    @Override
    public List<Permission> findOtherPermissions(String roleId) {
        return roleDao.findOtherPermissions(roleId);
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public List<Role> findAll() throws Exception{
        return roleDao.findAll();
    }
}
