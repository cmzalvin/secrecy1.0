package com.egov.secrecysystem.controller;

import org.directwebremoting.annotations.RemoteProxy;
import org.directwebremoting.spring.SpringCreator;
import org.springframework.beans.factory.annotation.Autowired;

import com.egov.secrecysystem.service.UserService;

@RemoteProxy(creator = SpringCreator.class)
public class UserController {

	@Autowired
	private UserService userservice;
	

}
