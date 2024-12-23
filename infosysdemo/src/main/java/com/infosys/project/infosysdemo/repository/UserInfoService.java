package com.infosys.project.infosysdemo.repository;

import org.springframework.stereotype.Component;

import com.infosys.project.infosysdemo.dao.UserEntity;

@Component
public interface UserInfoService {

	public String addUser(UserEntity userInfo);
}
