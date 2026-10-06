package com.betacom.objects;

import lombok.Getter;
import lombok.Setter;
import lombok.SuperBuilder;
import lombok.ToString;

@Getter
@Setter
@SuperBuilder
@ToString
public class ObjectPadre {
	String nome;
	String cognome;
	Boolean sesso;
}
