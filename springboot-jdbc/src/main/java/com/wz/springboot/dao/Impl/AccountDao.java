package com.wz.springboot.dao.Impl;

import com.wz.springboot.dao.IAccountDao;
import com.wz.springboot.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDao implements IAccountDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int addAccout(Account account) {
        return jdbcTemplate.update("insert into account (name ,money) values (?,?)",account.getName(),account.getMoney());
    }

    @Override
    public int deleteAccountById(int id) {
        return jdbcTemplate.update("delete from accout where id = ?",id);
    }

    @Override
    public int updateAccount(Account account) {
        return jdbcTemplate.update("update account set name = ? and money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
    }

    @Override
    public Account findAccountById(int id) {
        return jdbcTemplate.queryForObject("select * from account where id = ?",new Object[]{id},new BeanPropertyRowMapper<>(Account.class));
    }

    @Override
    public List<Account> findAllAccount() {
        return jdbcTemplate.queryForList("select * from accout",Account.class);
    }
}
