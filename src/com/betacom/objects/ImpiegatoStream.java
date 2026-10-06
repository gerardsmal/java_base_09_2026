package com.betacom.objects;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class ImpiegatoStream {
	private String nome;
	private Boolean sesso;
}
