package com.wz.springboot.service;

import com.wz.springboot.entity.Address;

import java.util.List;

public interface IAddressService {

    /**
     * 创建收货地址
     * @param uid
     * @param address
     * @return
     */
    Address createAddress(Integer uid, Address address);

    /**
     * 删除收货地址
     * @param uid
     * @param aid
     */
    void deleteAddress(Integer uid,Integer aid);

    /**
     * 查询用户的所有收货地址
     * @param uid
     * @return
     */
    List<Address> listAddresses(Integer uid);

}
