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

/**
 * The Class Address.
 */
public class Address implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3671020203176342690L;


	/** The state. */
	private String state;

	/** The country. */
	private String country;

	/**
	 * Instantiates a new address.
	 */
	public Address() {

	}

	/**
	 * Instantiates a new address.
	 *
	 * @param state the state
	 * @param country the country
	 */
	public Address(String state, String country) {
		super();
		this.state = state;
		this.country = country;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [state=" + state + ", country=" + country + "]";
	}
}
