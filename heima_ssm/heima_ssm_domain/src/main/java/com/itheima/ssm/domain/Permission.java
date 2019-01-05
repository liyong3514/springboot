package com.itheima.ssm.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "permission")
public class Permission {
    @Id
    private String id;
    private String permissionName;
    private String url;
    @ManyToMany(mappedBy = "permissions")
    private List<Role> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
