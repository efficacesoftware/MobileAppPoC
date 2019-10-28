package com.mobileappservice.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.mobileappservice.dao.UserDAO;
import com.mobileappservice.model.UserVo;


@Repository
public class UserDAOImpl implements UserDAO{

	final String SELECT_SQL = "select um.userid, um.emailId, um.firstName from usermaster um "
			+ "where um.emailID=? and um.password=?";
	final String INSERT_SQL = "insert into usermaster(userId,firstName,lastName,emailID,password,confirmPassword,phoneNo) "
			+ "values(?,?,?,?,?,?,?)";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<UserVo> login(String emailId, String password) {	
		return jdbcTemplate.query(SELECT_SQL, new Object[] { emailId, password }, new ResultSetExtractor<List<UserVo>>() {

						@Override
						public List<UserVo> extractData(ResultSet rs) throws SQLException, DataAccessException {
							
							List<UserVo> listOfUsers = new ArrayList<UserVo>();
							while(rs.next()) {
								UserVo userVo = new UserVo();
								userVo.setUserId(rs.getInt(1));
								userVo.setEmailID(rs.getString(2));
								userVo.setFirstName(rs.getString(3));
								listOfUsers.add(userVo);
							}
							return listOfUsers;
						}
			  });
		
	}
	

	
	@Override
	public int register(UserVo userVo) {
		return jdbcTemplate.update(INSERT_SQL, new Object[] { userVo.getUserId(), userVo.getFirstName(),
				userVo.getLastName(), userVo.getEmailID(),userVo.getPassword(),userVo.getConfirmPassword(),userVo.getPhoneNo()});
	}


	/*
	
	create database mobileapp;
	use mobileapp;
	create table usermaster(
	userId int,
	firstName varchar(10),
	lastName varchar(10),
	emailID varchar(20),
	password varchar(20),
	confirmPassword varchar(20),
	phoneNo long );
	
	insert into usermaster values(1,'raju','prasad','raju@gmail.com','rajuprasad','rajuprasad',7827595105);
	
	 *
	 *
	 */
	}
