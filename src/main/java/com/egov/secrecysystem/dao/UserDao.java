package com.egov.secrecysystem.dao;


import java.util.List;

import org.hibernate.Query;

import com.egov.secrecysystem.model.SeUser;





public class UserDao extends AbstractHibernateDao<SeUser>{
	
	UserDao(){
		super(SeUser.class);
	}
	

	public String validateLogin(String name, String password) {
		String hql = "select e from com.egov.secrecysystem.model.SeUser e where e.loginname=:Name and e.password=:Password";
		Query query=this.getCurrentSession().createQuery(hql);
		query.setParameter("Name",name);
		query.setParameter("Password",password);
		List<SeUser> result=query.list();
		if(result.size()!=1)
			return null;	
		else return "ok";
	}
	public SeUser getRoleByLoginName(String loginName) {
		String hql = "select e from com.egov.secrecysystem.model.SeUser e where e.loginname=:loginName";
		Query query=this.getCurrentSession().createQuery(hql);
		query.setParameter("loginName",loginName);
		List<SeUser> result=query.list();
		if(result.size()==1)
			return result.get(0);
		return null;
	}
	public Integer getRoleLevelByLoginName(String loginName) {
		String  hql= "select e.userlevel from com.egov.secrecysystem.model.SeUser e where e.loginname=:loginName";
		Query query=this.getCurrentSession().createQuery(hql);
		query.setParameter("loginName",loginName);
		List<String> result=query.list();
		if(result.size()==1)
			return Integer.parseInt(result.get(0));
		return -1;
	}
	
}
