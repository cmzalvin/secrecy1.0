package com.egov.secrecysystem.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.Query;

import com.egov.secrecysystem.model.SeRole;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;

public class RoleDao  extends AbstractHibernateDao<SeRole> {

	RoleDao(){
		super(SeRole.class);
	}
	
	public List<SeRole> getByRemark(String remark){
		String hql = "select r from com.egov.secrecysystem.model.SeRole r where r.remark =:remark";
		return (List<SeRole>)this.getCurrentSession().createQuery(hql).setParameter("remark", remark).list();
	}
	
	public String getRoleRemarkByRoleNum(Integer roleNum){
		String hql="select e.remark from com.egov.secrecysystem.model.SeRole e where e.rolenum=:roleNum";
		List<String> result= this.getCurrentSession().createQuery(hql).setParameter("roleNum", roleNum).list();
		if(result.size()!=1)
			return null;
		return result.get(0);
	}

	public SeRole getRoleByRoleName(String name) {
		String hql="select e from com.egov.secrecysystem.model.SeRole e where e.name=:name";
		//List<SeRole> result= this.getCurrentSession().createQuery(hql).setParameter("name", name).list();
		Query query=this.getCurrentSession().createQuery(hql);
		query.setParameter("name", name);
		List<SeRole> result=query.list();
		if(result.size()!=1)
			return null;
		return result.get(0);
	}
	/*
	public Integer getRoleNum(Integer num) {
		String hql="select e.rolenum from com.egov.secrecysystem.model.SeRole e where e.rolenum=:num";
		Query query=this.getCurrentSession().createQuery(hql);
		query.setParameter("num", num);
		List<Integer> result=query.list();
		if(result.size()!=1)
			return null;
		return result.get(0);
	}*/
	/*
	public SeRole getRoleByLoginName(String name) {
		String hql = "select r from com.egov.secrecysystem.model.SeRole r,com.egov.secrecysystem.model.SeUser u "
				+ "where u.loginname=:name and u.roleid=r.id";
		List<SeRole> result = this.getCurrentSession().createQuery(hql)
				.setParameter("name", name).list();
		if (result.size() != 1)
			return null;
		return result.get(0);
	}*/
	
}
