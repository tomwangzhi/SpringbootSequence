package com.wz.springboot.dao;

import com.wz.springboot.entity.Account;

import java.util.List;

public interface IAccountDao {

    int addAccout(Account account);

    int deleteAccountById(int id );

    int updateAccount(Account account);

    Account findAccountById(int id);

    List<Account> findAllAccount();

}
