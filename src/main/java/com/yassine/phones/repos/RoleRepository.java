package com.yassine.phones.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yassine.phones.entities.Role;
public interface RoleRepository extends JpaRepository<Role, Long> {
Role findByRole(String role);
}
