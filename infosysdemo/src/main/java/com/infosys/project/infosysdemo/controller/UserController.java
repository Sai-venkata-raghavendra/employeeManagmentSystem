package com.infosys.project.infosysdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.project.infosysdemo.dao.UserEntity;
import com.infosys.project.infosysdemo.service.JwtService;
import com.infosys.project.infosysdemo.service.UserInfoServiceImpl;
import com.infosys.project.infosysdemo.vo.AuthenticationRequest;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserInfoServiceImpl userInfoService;

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtService jwtService;

	@PostMapping("/new")
	public ResponseEntity<String> addUserDetails(@RequestBody UserEntity userInputVO) throws Exception {

		return new ResponseEntity<String>(userInfoService.addUser(userInputVO), HttpStatus.ACCEPTED);
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthenticationRequest authRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(authRequest.getUsername());
		} else {
			throw new UsernameNotFoundException("Invalid User");
		}
	}
}
