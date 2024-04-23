package com.yassine.phones.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yassine.phones.entities.SmartPhone;

public interface PhonesRepostory extends JpaRepository<SmartPhone, Long> {

}
