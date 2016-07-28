package com.andy.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the permissions database table.
 * 
 */
@Entity
@Table(name="permissions")
@NamedQuery(name="Permission.findAll", query="SELECT p FROM Permission p")
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="perm_code")
	private String permCode;

	@Column(name="perm_name")
	private String permName;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User TUser;

	public Permission() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPermCode() {
		return this.permCode;
	}

	public void setPermCode(String permCode) {
		this.permCode = permCode;
	}

	public String getPermName() {
		return this.permName;
	}

	public void setPermName(String permName) {
		this.permName = permName;
	}

	public User getTUser() {
		return this.TUser;
	}

	public void setTUser(User TUser) {
		this.TUser = TUser;
	}

}