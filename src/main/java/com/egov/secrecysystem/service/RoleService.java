package com.egov.secrecysystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.egov.secrecysystem.dao.RoleDao;
import com.egov.secrecysystem.model.SeRole;



@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RoleService {
	@Autowired
	private RoleDao roleDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public String getRoleRemarkByRoleNum(Integer roleNum){
		return this.roleDao.getRoleRemarkByRoleNum(roleNum);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public SeRole getRoleByRoleName(String roleName){
		return this.roleDao.getRoleByRoleName(roleName);
	}
	/*
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Integer getRoleNum(Integer rolenum){
		return this.roleDao.getRoleNum(rolenum);
	}*/
	/*
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public SeRole getRoleByLoginName(String loginName){
		return this.roleDao.getRoleByLoginName(loginName);
	}*/
}
