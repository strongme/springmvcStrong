package org.strongme.walter.pojo;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class User {
	@NotEmpty(message="亲起码随便填一个好么")
	@Size(min=6,max=12,message="长度不合适亲")
	private String name;
	private String gender;
	@NotEmpty(message="亲起码随便填一个好么")
	@Size(min=6,max=24,message="长度不合适亲")
	@Pattern(regexp="^[a-zA-Z0-9]+$", message="用户名是没有空格的亲")
	private String username;
	@NotEmpty(message="亲起码随便填一个好么")
	@Size(min=6,max=12,message="长度不合适亲")
	@Pattern(regexp="^[a-zA-Z0-9]+$", message="密码是没有空格的亲")
	private String password;
	private Short age;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Short getAge() {
		return age;
	}
	public void setAge(Short age) {
		this.age = age;
	}
	
	

}
