package com.infosys.project.infosysdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.infosys.project.infosysdemo.dao.UserEntity;
import com.infosys.project.infosysdemo.repository.UserInfoService;
import com.infosys.project.infosysdemo.repository.UserRepository;
import com.infosys.project.infosysdemo.vo.UserOutputVO;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	private boolean flag;

	@Override
	public String addUser(UserEntity userInfo) {

		List<UserEntity> userList = userRepository.findAll();
		System.out.println(flag);
		System.out.println(userList);
		if (null != userList) {
			for (UserEntity user : userList) {
				if (user.getUserName().equals(userInfo.getUserName())) {
					flag = true;
				} else {
					flag = false;
				}
			}
		}
		System.out.println(flag);
		if (flag) {
			return "User already exists";
		} else {
			System.out.println(userInfo);
			System.out.println(userInfo.getUserName());
			// System.out.println(userInfo.getPwd());
			System.out.println("ADMIN");
			System.out.println(userInfo.getId());
			userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
			userRepository.save(userInfo);
			return "User saved";
		}
	}

}
