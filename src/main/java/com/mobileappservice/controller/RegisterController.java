package com.mobileappservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mobileappservice.dao.UserDAO;
import com.mobileappservice.model.UserLoginResponse;
import com.mobileappservice.model.UserVo;


@RestController
public class RegisterController {
	
	public static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
		/*
		 * use following url to execute the service
		 * http://localhost:7801/userService/register
		 */

	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value="/userService/register", method=RequestMethod.POST)
	public UserLoginResponse reigster(@RequestBody UserVo userVo) throws Exception {
	int isRegister = userDAO.register(userVo);
		if (isRegister == 1) {
			return new UserLoginResponse( 
					200, 
					"Success",
					"User Registered successfully");
		} else {
			return new UserLoginResponse(401,"Failure ","FAILURE");
		}

	}
}
	

	




