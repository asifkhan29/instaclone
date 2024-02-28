package com.instaclone.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instaclone.dto.UserDTO;
import com.instaclone.dto.UserLoginRequest;
import com.instaclone.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	final private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<?> userRegister(@RequestBody UserDTO userDTO) {
		UserDTO userDTO1 = userService.register(userDTO);
		return ResponseEntity.ok(userDTO1);
	}

	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody UserLoginRequest userLoginRequest) {
		UserDTO userDTO = userService.login(userLoginRequest.userNameOrEmail(), userLoginRequest.password());
		return ResponseEntity.ok(userDTO);
	}

}
