package com.yassine.phones.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yassine.phones.entities.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {
	
}