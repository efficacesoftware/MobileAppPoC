package com.mobileappservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mobileappservice.dao.UserDAO;
import com.mobileappservice.model.UserVo;
import com.mobileappservice.model.UserLoginResponse;


@RestController
public class LoginController {
	
	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);
		/*
		 * use following url to execute the service
		 * http://localhost:7801/userService/login/k@gmail.com/password
		 */

	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value="/userService/login/{emailId}/{password}", method=RequestMethod.GET)
	public UserLoginResponse login(@PathVariable String emailId, @PathVariable("password") String password) throws Exception {
		
		List<UserVo> userList = userDAO.login(emailId, password);
		if (!CollectionUtils.isEmpty(userList)) {
			UserVo userVo = userList.get(0);
			return new UserLoginResponse(userVo.getUserId(),
					userVo.getEmailID(),
					userVo.getFirstName(), 
					200, 
					"Success",
					"Customer logged successfully");
		} else {
			return new UserLoginResponse(401,"emailId or password wrong ","FAILURE");
		}

	}
}
	

	




