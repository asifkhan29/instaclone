package com.instaclone.service.impl;

import java.util.Optional;



import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.instaclone.dto.UserDTO;
import com.instaclone.entity.User;
import com.instaclone.exception.UserException;
import com.instaclone.repo.UserRepository;
import com.instaclone.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

	final private UserRepository userRepository;

	final private ModelMapper modelMapper;
	
	 //Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	
	
	@Value("${user.userNameExistsErrorCode}")
	public String errorCodeUserNameExists;
	@Value("${user.userNameExistsErrorMessage}")
	public  String  errorMessageUserNameExists;
	
	@Value("${user.userNameAndEmailNotFoundCode}")
	public String errorCodeUserNameAndEmailNotFound;
	@Value("${user.userNameAndEmailNotFoundMessage}")
	public  String  errorMessageUserNameAndEmailNotFound;
	
	@Value("${user.passwordDoesntMatchCode}")
	public String errorCodePasswordDoesntMatch;
	@Value("${user.passwordDoesntMatchMessage}")
	public  String  errorMessagePasswordDoesntMatch;



	@Override
	public UserDTO register(UserDTO userDTO) throws UserException {
		// TODO Auto-generated method stub

		boolean existEmailOrUserName = userRepository.existsByUserNameOrEmailId(userDTO.getUserName(),
				userDTO.getEmailId());
		if (existEmailOrUserName == true) {
			log.info("email A {} :" , userDTO.getEmailId());
			throw new UserException(errorCodeUserNameExists, errorMessageUserNameExists,
					HttpStatus.NOT_ACCEPTABLE);
			
		}

		User user = modelMapper.map(userDTO, User.class);
		User savedUser = userRepository.save(user);
		savedUser.setPassword("");
		return modelMapper.map(savedUser, UserDTO.class);

	}

	@Override
	public UserDTO login(String usernameAndEmail, String password) throws UserException {
		Optional<User> user = userRepository.findByUserNameOrEmailId(usernameAndEmail, usernameAndEmail);
		if (!user.isPresent()) {
			throw new UserException(errorCodeUserNameAndEmailNotFound,
					errorMessageUserNameAndEmailNotFound, HttpStatus.NOT_FOUND);

		} else if (!user.get().getPassword().equals(password)) {
			throw new UserException(errorCodePasswordDoesntMatch,
					errorMessagePasswordDoesntMatch, HttpStatus.NOT_FOUND);
		}
		user.get().setPassword("");
		return modelMapper.map(user.get(), UserDTO.class);

	}

}
