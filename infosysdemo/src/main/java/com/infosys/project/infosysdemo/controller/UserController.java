package com.infosys.project.infosysdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.project.infosysdemo.dao.UserEntity;
import com.infosys.project.infosysdemo.service.UserInfoServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserInfoServiceImpl userInfoService;

	@PostMapping("/new")
	public ResponseEntity<String> addUserDetails(@RequestBody UserEntity userInputVO) throws Exception {

		return new ResponseEntity<String>(userInfoService.addUser(userInputVO), HttpStatus.ACCEPTED);
	}

}
