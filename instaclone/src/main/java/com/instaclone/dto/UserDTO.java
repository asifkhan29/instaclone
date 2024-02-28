package com.instaclone.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
	
	private long id;
	private String userName;
	private String name;
	private String emailId;
	private String age;
	private String gender;
	private String city;
	@ToString.Exclude
	private String password;

}
