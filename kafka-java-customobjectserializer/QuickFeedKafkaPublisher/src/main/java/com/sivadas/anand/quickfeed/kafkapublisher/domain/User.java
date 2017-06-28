/*
 * Copyright (c) 2017 Author(s). All rights reserved.
 * 
 * @Author	- Anand Sivadas
 * @Date	- 28 Jun, 2017
 * 
 * 
 */
package com.sivadas.anand.quickfeed.kafkapublisher.domain;

import java.io.Serializable;

/**
 * The Class User.
 */
public class User implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -598392771367916891L;

	/** The name. */
	private String name;

	/** The age. */
	private int age;
	
	/** The address. */
	private Address address;

	/**
	 * Instantiates a new user.
	 */
	public User() {
		
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param name the name
	 * @param age the age
	 * @param address the address
	 */
	public User(String name, int age, Address address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {

		return this.name;

	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {

		return this.age;

	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", address=" + address
				+ "]";
	}
}