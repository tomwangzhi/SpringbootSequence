package com.wz.springboot;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.wz.springboot.dao.UserMongoDao;
import com.wz.springboot.entity.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

@Slf4j
public class AppUserDaoTest extends SpringbootMongoApplicationTests {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    UserMongoDao userMongoDao;

    private static Snowflake snowflake;

    @BeforeClass
    public static void buildCommon() {
         snowflake = new Snowflake(1,1);
    }

    /**
     * 添加一个用户信息到mongo中去 用到hutool工具找那个的雪花算法，以及json工具
     */
    @Test
    public void testUserAdd() {
        AppUser appUser = AppUser.builder().id(1L).createTime(DateUtil.date())
                .updateTime(DateUtil.date())
                .enabled(true)
                .headImgUrl(RandomUtil.randomString(10))
                .nickname("root")
                .password("root")
                .sex(1)
                .phone(RandomUtil.randomNumbers(11)).build();
        userMongoDao.save(appUser);
        log.info("【appUser】= {}", JSONUtil.toJsonStr(appUser));
    }

    @Test
    public void queryUser() {

        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(1L));
        List<AppUser> appUsers = mongoTemplate.find(query, AppUser.class);
        log.info("【appUsers】={}",JSONUtil.toJsonStr(appUsers));

    }

    @Test
    public void updateUserSex() {

        userMongoDao.findById(1L).ifPresent(user->{
            user.setNickname("更新nickname");
            user.setSex(0);
            userMongoDao.save(user);
            log.info(" update【appUsers】={}",user);
        });

    }

    @Test
    public void testDelUser() {
        userMongoDao.deleteById(1l);
        userMongoDao.findById(1l).ifPresent(user -> {
            log.info("【appUser】={}",user);
        });
    }

    @Test
    public void testUpdate() {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(1L));
        Update update = new Update();
        update.inc("sex", 99);
        update.addToSet("username", "test");
        mongoTemplate.updateFirst(query, update, "appUser");
    }



}
