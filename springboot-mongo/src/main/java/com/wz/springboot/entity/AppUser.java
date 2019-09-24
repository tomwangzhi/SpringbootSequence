package com.wz.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser implements Serializable {

	private static final long serialVersionUID = 611197991672067628L;


	@Id
	private Long id;
	@NotEmpty(message = "username is not empty")
	private String username;
	@NotEmpty(message = "password is not empty")
	private String password;
	private String nickname;
	@NotEmpty(message = "headImgUrl is not empty")
	private String headImgUrl;
	private String phone;
	private Integer sex;
	/**
	 * 状态
	 */
	private Boolean enabled;
	private String type;
	@DateTimeFormat(pattern = "yy-mm-dddd hh:mm:ss")
	private Date createTime;
	@DateTimeFormat(pattern = "yy-mm-dddd hh:mm:ss")
	private Date updateTime;


}
