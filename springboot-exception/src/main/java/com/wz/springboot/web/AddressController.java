package com.wz.springboot.web;

import com.wz.springboot.dto.AddressDTO;
import com.wz.springboot.entity.Address;
import com.wz.springboot.exception.ApiNotFindAddressException;
import com.wz.springboot.exception.UserNotFindException;
import com.wz.springboot.service.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    @Autowired
    IAddressService addressService;

    @RequestMapping(method = RequestMethod.POST)
    public AddressDTO add(@Validated @RequestBody AddressDTO addressDTO) {
        Address address = new Address();
        BeanUtils.copyProperties(addressDTO, address);
        Address result;
        try {
            result = addressService.createAddress(addressDTO.getUid(), address);
        }catch (UserNotFindException e) {
            throw new ApiNotFindAddressException("找不到该用户");
        }
        AddressDTO addDTO = new AddressDTO();
        BeanUtils.copyProperties(result,addDTO);

        return addDTO;
    }
}
