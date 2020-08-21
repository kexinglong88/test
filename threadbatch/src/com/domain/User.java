package com.domain;

/**
 * @desciption: 用户实体
 * @author: kexl
 * @date: 2020-08-21
 */
public class User {

	private Integer id;

	private String name;

	public User(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public User() {
		super();
	}

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
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

}
