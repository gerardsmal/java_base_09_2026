package com.betacom.objects;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address implements Serializable{

	private static final long serialVersionUID = 3L;
	
	private String street;
	private String city;
	private String name;
	private Boolean sesso;
	private String desc;
	private transient String pwd;
	
	
}
