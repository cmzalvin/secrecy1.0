package com.egov.secrecysystem.service;


import com.egov.secrecysystem.model.SeUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.egov.secrecysystem.dao.RoleDao;
import com.egov.secrecysystem.dao.UserDao;
//import cn.hdu.examsignup.dao.InstitutionDao;
//import org.resource.model.ExInstitution;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	private RoleDao roledao;
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public String validateLogin(String name,String password) {
		String temp = this.userDao.validateLogin(name, password);
		return temp;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public SeUser getRoleByLoginName(String loginName){
		return this.userDao.getRoleByLoginName(loginName);
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Integer getRoleLevelByLoginName(String loginName) {
		return userDao.getRoleLevelByLoginName(loginName);
	}
}
