package com.infosys.project.infosysdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.project.infosysdemo.service.JwtService;
import com.infosys.project.infosysdemo.vo.AuthenticationRequest;

@RestController
@RequestMapping("/auth")
public class AuthenticateContoller {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtService jwtService;

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
