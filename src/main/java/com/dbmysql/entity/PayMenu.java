package com.dbmysql.entity;

import java.util.List;

public class PayMenu {
    private Integer id;

    private String name;

    private String url;

    private Integer pid;

    private Integer status;
    
    private List<PayMenu> subMenus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	public List<PayMenu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<PayMenu> subMenus) {
		this.subMenus = subMenus;
	}
    
}