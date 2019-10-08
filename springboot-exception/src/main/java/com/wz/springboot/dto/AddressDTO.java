package com.wz.springboot.dto;

import com.wz.springboot.entity.User;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
public class AddressDTO {

    private Integer id;
    @NotEmpty
    private String province;//省
    @NotEmpty
    private String city;//市
    @NotEmpty
    private String county;//区
    private Boolean isDefault;//是否是默认地址

    private Integer uid;
}
