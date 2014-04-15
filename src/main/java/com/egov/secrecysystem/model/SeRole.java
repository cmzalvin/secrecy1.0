package com.egov.secrecysystem.model;
// Generated 2012-3-26 19:37:27 by Hibernate Tools 3.4.0.CR1


import java.util.HashSet;
import java.util.Set;

import org.directwebremoting.annotations.DataTransferObject;

/**
 * ExRole generated by hbm2java
 */
@DataTransferObject
public class SeRole  implements java.io.Serializable {


     private String id;
     private Integer rolenum;
     private String name;
     private String remark;
     private Set seMainmenus = new HashSet(0);
     private Set seUsers = new HashSet(0);

    public SeRole() {
    }

	
    public SeRole(String id) {
        this.id = id;
    }
    public SeRole(String id, Integer rolenum, String name, String remark, Set seMainmenus, Set seUsers) {
       this.id = id;
       this.rolenum = rolenum;
       this.name = name;
       this.remark = remark;
       this.seMainmenus = seMainmenus;
       this.seUsers = seUsers;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public Integer getRolenum() {
        return this.rolenum;
    }
    
    public void setRolenum(Integer rolenum) {
        this.rolenum = rolenum;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Set getSeMainmenus() {
        return this.seMainmenus;
    }
    
    public void setSeMainmenus(Set seMainmenus) {
        this.seMainmenus = seMainmenus;
    }
    public Set getSeUsers() {
        return this.seUsers;
    }
    
    public void setSeUsers(Set seUsers) {
        this.seUsers = seUsers;
    }




}

