package com.wz.springboot.web;


import com.wz.springboot.entity.Account;
import com.wz.springboot.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    IAccountService accountService;
    @RequestMapping(value = "/account/add",method = RequestMethod.POST)
    public String addAccount(@RequestBody Account account) {
        int i = accountService.addAccout(account);
        return String.valueOf(i);
    }

    @RequestMapping(value = "/account/{id}",method = RequestMethod.GET)
    public Account getAccountById(@PathVariable(value = "id") int id) {
        return accountService.findAccountById(id);
    }
}
