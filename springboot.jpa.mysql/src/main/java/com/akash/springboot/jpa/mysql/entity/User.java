/**
 * 
 */
package com.akash.springboot.jpa.mysql.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Akash
 *
 */

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String name;
	@Column(columnDefinition = "int(12)")
	private Integer phone;

	/**
	 * Parameterized constructor
	 * 
	 * @param id    -Integer
	 * @param name  -String
	 * @param phone -Integer
	 */
	public User(long id, String name, Integer phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	/**
	 * Default constructor
	 */
	public User() {

	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phone
	 */
	public Integer getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(Integer phone) {
		this.phone = phone;
	}

}
