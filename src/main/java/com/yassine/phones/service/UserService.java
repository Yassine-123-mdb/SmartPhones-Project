package com.yassine.phones.service;

import com.yassine.phones.entities.Role;
import com.yassine.phones.entities.User;
public interface UserService {
void deleteAllusers();
void deleteAllRoles();
User saveUser(User user);
User findUserByUsername (String username);
Role addRole(Role role);
User addRoleToUser(String username, String rolename);
}
