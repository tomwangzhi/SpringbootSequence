package com.wz.springboot.service.impl;

import com.google.common.base.Preconditions;
import com.wz.springboot.dao.IAdderessDao;
import com.wz.springboot.dao.IUserDao;
import com.wz.springboot.entity.Address;
import com.wz.springboot.entity.User;
import com.wz.springboot.exception.UserNotFindException;
import com.wz.springboot.service.IAddressService;
import com.wz.springboot.util.BeanValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    IAdderessDao iAdderessDao;

    @Autowired
    IUserDao iUserDao;

    @Qualifier("getValidator")
    @Resource
    private Validator validator ;

    @Override
    public Address createAddress(Integer uid, Address address) {

        //1.用户id不能为空，且此用户确实是存在的 guava库校验
        Preconditions.checkNotNull(uid);
        Optional<User> user = iUserDao.findById(uid);

        if(!user.isPresent()) {
            throw new UserNotFindException("用户不存在！");
        }

        //2.收货地址的必要字段不能为空 jsr hibernate-validate校验参数
        BeanValidators.validateWithException(validator,address);

        //3.如果用户还没有收货地址，当此收货地址创建时设置成默认收货地址
        if(ObjectUtils.isEmpty(user.get().getAid())){
            address.setIsDefault(true);
        }

        //============ 以下为正常执行的业务逻辑   ==============
        Address result = iAdderessDao.save(address);

        return result;
    }

    @Override
    public void deleteAddress(Integer uid, Integer aid) {

    }

    @Override
    public List<Address> listAddresses(Integer uid) {
        return null;
    }
}
