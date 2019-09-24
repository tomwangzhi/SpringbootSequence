package com.wz.springboot.dao;

import com.wz.springboot.entity.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 操作mongo的简化实现接口，有代理去找到具体的实现类
 */
public interface UserMongoDao extends MongoRepository<AppUser,Long> {

}
