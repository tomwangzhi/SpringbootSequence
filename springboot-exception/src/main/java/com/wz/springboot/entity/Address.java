package com.wz.springboot.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "t_address")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
