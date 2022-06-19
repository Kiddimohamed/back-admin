package com.example.backadmin.security.service.facade;



import com.example.backadmin.security.bean.Role;

import java.util.Collection;

public interface RoleService {
    Role save(Role role);

    void save(Collection<Role> roles);

    Role findByAuthority(String authority);
}
