package com.jcohy.rabbit.sample.model;

import java.io.Serializable;

/**
 * @author jiac <a href="https://www.jcohy.com"></a>
 * @since 1.0.0 2020/04/13 2020/4/13:10:47 Description
 */
public class Order implements Serializable {

	private String userId;

	private String username;

	private String description;

	public Order(String userId, String username, String description) {
		this.userId = userId;
		this.username = username;
		this.description = description;
	}

	public Order() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Order{" + "userId=" + userId + ", username='" + username + '\'' + ", description='" + description + '\''
				+ '}';
	}

}
