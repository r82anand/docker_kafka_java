/*
 * Copyright (c) 2017 Author(s). All rights reserved.
 * 
 * @Author	- Anand Sivadas
 * @Date	- 28 Jun, 2017
 * 
 * 
 */
package com.sivadas.anand.quickfeed.kafkaclient.domain;

import java.io.Serializable;
import java.util.List;

/**
 * The Class UserFeeds.
 */
public class UserFeeds implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5863901554923684995L;

	/** The user list. */
	private List<User> userList;
	
	/** The some text. */
	private String someText;
	
	/**
	 * Gets the some text.
	 *
	 * @return the some text
	 */
	public String getSomeText() {
		return someText;
	}

	/**
	 * Sets the some text.
	 *
	 * @param someText the new some text
	 */
	public void setSomeText(String someText) {
		this.someText = someText;
	}

	/**
	 * Gets the some int.
	 *
	 * @return the some int
	 */
	public int getSomeInt() {
		return someInt;
	}

	/**
	 * Sets the some int.
	 *
	 * @param someInt the new some int
	 */
	public void setSomeInt(int someInt) {
		this.someInt = someInt;
	}

	/** The some int. */
	private int someInt;

	/**
	 * Gets the user list.
	 *
	 * @return the user list
	 */
	public List<User> getUserList() {
		return userList;
	}

	/**
	 * Sets the user list.
	 *
	 * @param userList the new user list
	 */
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
}
