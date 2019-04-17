package com.wz.springboot.service.Impl;

import com.wz.springboot.dao.IAccountDao;
import com.wz.springboot.entity.Account;
import com.wz.springboot.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    IAccountDao accountDao;

    public int addAccout(Account account) {

        return accountDao.addAccout(account);
    }

    public int deleteAccountById(int id ) {
        return accountDao.deleteAccountById(id);
    }

    public int updateAccount(Account account) {
        return accountDao.updateAccount(account);
    }

    public Account findAccountById(int id) {
        return accountDao.findAccountById(id);
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }
}
