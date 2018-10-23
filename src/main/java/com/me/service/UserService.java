package com.me.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.mapper.UserMapper;
import com.me.pojo.User;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public User selectUserById(int i) {
		return userMapper.selectByPrimaryKey(i);
	}
	
	public void updateUserById(User user) {
		
		userMapper.updateByPrimaryKey(user);
	}
}
