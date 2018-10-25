package com.me.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.exceptions.UserException;
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
		userMapper.updateByPrimaryKeyWithBLOBs(user);
	}
	
	public void updateUserByIdPlus(User user) throws UserException {
		if(user.getId()!=null) {
			User usert=userMapper.selectByPrimaryKey(user.getId());
			if(user.getName()!=null) {
				usert.setName(user.getName());
			}
			if(user.getBirth()!=null) {
				usert.setBirth(user.getBirth());
			}
			if(user.getHead()!=null) {
				usert.setHead(user.getHead());
			}
			updateUserById(usert);
		}else {
			throw new UserException("用户身份异常");
		}
	}
}
