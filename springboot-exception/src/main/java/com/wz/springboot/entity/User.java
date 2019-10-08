package com.wz.springboot.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_user")
@Data
public class User {

    @Id
    @GeneratedValue
    private Integer uid;
    private String name;//姓名
    private Integer aid;



}
