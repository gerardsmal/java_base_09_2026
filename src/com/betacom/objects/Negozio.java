package com.betacom.objects;

public class Negozio {
	private int codice;
	private String proprietario;
	private String indirizzo;
	private Boolean isCenterCommerciale;
	
	private Negozio() {
	}
	
	public static class Builder{
		private int codice;
		private String proprietario;
		private String indirizzo;
		private Boolean isCenterCommerciale;
				
		public Builder codice(int codice) {
			this.codice = codice;
			return this;
		}

		public Builder proprietario(String  proprietario) {
			this.proprietario = proprietario;
			return this;
		}
		
		public Builder indirizzo(String  indirizzo) {
			this.indirizzo = indirizzo;
			return this;
		}

		public Builder isCenterCommerciale(Boolean  isCenterCommerciale) {
			this.isCenterCommerciale = isCenterCommerciale;
			return this;
		}

		public Negozio build() {
			Negozio negozio = new Negozio();
			negozio.codice = codice;
			negozio.proprietario = proprietario;
			negozio.indirizzo = indirizzo;
			negozio.isCenterCommerciale = isCenterCommerciale;
			return negozio;
		}
		
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	@Override
	public String toString() {
		return "Negozio [codice=" + codice + ", proprietario=" + proprietario + ", indirizzo=" + indirizzo
				+ ", isCenterCommerciale=" + isCenterCommerciale + "]";
	}

}
