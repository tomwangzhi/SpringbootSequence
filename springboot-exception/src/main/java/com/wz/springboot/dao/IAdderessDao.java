package com.wz.springboot.dao;

import com.wz.springboot.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdderessDao extends JpaRepository<Address,Integer> {
}
