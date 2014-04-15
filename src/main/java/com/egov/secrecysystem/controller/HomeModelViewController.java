package com.egov.secrecysystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.egov.secrecysystem.service.MainMenuService;
import com.egov.secrecysystem.service.RoleService;
import com.egov.secrecysystem.service.UserService;

@Controller
public class HomeModelViewController {

	@Autowired
	private MainMenuService mainMenuService;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;



	@RequestMapping(value = "Home", method = RequestMethod.GET)
	public ModelAndView getindexPage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer roleNum=0;
		//String institution=null;
		ModelAndView model = new ModelAndView("Home");
		HttpSession curSession = request.getSession();
		
		roleNum=(Integer)curSession.getAttribute("role");
		//String remark=(String) curSession.getAttribute("remark");
		String loginName = (String)curSession.getAttribute("name");
		//roleNum = 0;
		model.addObject("menus", mainMenuService.getAuthorisedMenu(roleNum));
		//roleNum0，即管理员身份
		if(roleNum==0)
		{			
			model.addObject("loginname","管理员");
	//			model.addObject("loginname",instructorService.getInstructorByNum(loginName)+"("+loginName+")");
		}
		else{
			model.addObject("loginname", loginName);
		}
				
		return model;
	}
}
