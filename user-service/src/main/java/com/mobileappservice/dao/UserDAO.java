package com.mobileappservice.dao;

import java.util.List;

import com.mobileappservice.model.UserVo;


public interface UserDAO {
	
	public List<UserVo> login(String emailId, String password);
	public int register(UserVo userVo);
	
}
