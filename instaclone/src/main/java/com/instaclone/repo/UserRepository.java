package com.instaclone.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.instaclone.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	   
	 boolean existsByUserNameOrEmailId(String userName , String email); 
	 Optional<User> findByUserNameOrEmailId(String userName, String email);
	 

}
