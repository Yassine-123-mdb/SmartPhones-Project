package com.yassine.phones.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yassine.phones.entities.User;
public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}
