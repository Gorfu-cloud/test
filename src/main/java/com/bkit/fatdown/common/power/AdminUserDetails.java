package com.bkit.fatdown.common.power;

import com.bkit.fatdown.entity.TbAdmin;
import com.bkit.fatdown.entity.TbPermission;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @file: AdminUserDetails
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: SpringSecurity需要的用户详情
 * @date: Created in 2019/8/27 10:21
 * @modified:
 * @version: 1.0
 */
public class AdminUserDetails implements UserDetails {
    private TbAdmin admin;
    private List<TbPermission> permissionList;

    public AdminUserDetails(TbAdmin admin, List<TbPermission> permissionList) {
        this.admin = admin;
        this.permissionList = permissionList;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println(permissionList.stream()
                .filter(permission -> permission.getValue()!=null)
                .map(permission ->new SimpleGrantedAuthority(permission.getValue()))
                .collect(Collectors.toList()));

        //返回当前用户的权限
        return permissionList.stream()
                .filter(permission -> permission.getValue()!=null)
                .map(permission ->new SimpleGrantedAuthority(permission.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return admin.getPassword();
    }

    @Override
    public String getUsername() {
        return admin.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return admin.getStatus().equals(1);
    }
}
