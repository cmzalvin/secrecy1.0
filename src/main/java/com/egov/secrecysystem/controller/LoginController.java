package com.egov.secrecysystem.controller;

import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.egov.secrecysystem.service.RoleService;
import com.egov.secrecysystem.service.UserService;


@Controller
public class LoginController {

	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	private Logger logger= LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "HelloWorld", method = RequestMethod.GET)
	public ModelAndView helloworld(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("HelloWorld");
		model.addObject("msg", "Hello world222!!");
		request.setAttribute("a","111111111");
		return model;
	}

	@RequestMapping(value = "Login", method = RequestMethod.POST)
	public ModelAndView Login(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=UTF-8");

		Writer out = response.getWriter();
		HttpSession curSession = request.getSession();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String valid = null;

		if (name == null || password == null) {
			out.write("{ success: false, errors:{info: '无法获得用户、密码！'}}");
			return null;
		}

		name = name.trim();
		password = password.trim();
		if (name.isEmpty() || password.isEmpty()) {
			out.write("{ success: false, errors:{info: '用户、密码不能为空！'}}");
			return null;
		}

		valid = userService.validateLogin(name, password);
		if (valid == null) {
			out.write("{ success: false, errors:{info: '您的身份信息未通过验证！'}}");

			return null;
		}

		out.write("{ success: true, errors:{info: '通过验证！'}}");
		if (curSession.getAttribute("role") != null)
			curSession.removeAttribute("role");
		curSession.setAttribute("role", userService.getRoleLevelByLoginName(name));
		//curSession.setAttribute("remark",roleService.getRoleRemarkByRoleNum(roleService.getRoleByRoleName(name).getRolenum()));
		curSession.setAttribute("name", name);
		curSession.setAttribute("password", password);
		ModelAndView model = new ModelAndView("HelloWorld");
		model.addObject("msg", "Hello world222!!");
		return null;

	}

	@RequestMapping(value = "Logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession curSession = request.getSession();
		curSession.invalidate();
		
		ModelAndView model = new ModelAndView("../Info");
		model.addObject("msg", "注销成功");
		return model;
	}
	
	
	
	
	
	
	
	
	
	
}
