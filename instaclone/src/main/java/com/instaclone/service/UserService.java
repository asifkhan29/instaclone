package com.instaclone.service;

import com.instaclone.dto.UserDTO;

public interface UserService {

	UserDTO register(UserDTO userDTO);
	UserDTO login(String usernameAndEmail, String password);

}
