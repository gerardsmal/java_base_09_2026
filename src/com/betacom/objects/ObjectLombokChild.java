package com.betacom.objects;

import lombok.Getter;
import lombok.Setter;
import lombok.SuperBuilder;
import lombok.ToString;

@Setter
@Getter
@SuperBuilder
@ToString (callSuper = true)

public class ObjectLombokChild extends ObjectPadre{
	private String via;
	private String citta;
	
}
