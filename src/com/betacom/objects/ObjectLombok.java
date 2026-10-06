package com.betacom.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class ObjectLombok {
	private String nome;
	private String cognome;
	private String indirizzo;
	private Boolean sesso;
}
