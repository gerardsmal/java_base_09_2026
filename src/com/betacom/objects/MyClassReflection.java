package com.betacom.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyClassReflection {
	private Integer id;
	private String desc;
	private Integer p1;
	
	public MyClassReflection(Integer id, String desc) {
		this.id = id;
		this.desc = desc;		
	}
	

}
