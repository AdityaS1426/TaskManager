package com.booleans.taskmanagement.service;

import com.booleans.taskmanagement.model.Role;

import java.util.List;

public interface RoleService {
    Role createRole(Role role);

    List<Role> findAll();
}
