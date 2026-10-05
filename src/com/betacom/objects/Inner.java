package com.betacom.objects;

public class Inner {
	private String fatherClass;
	private int    numero;
	private Figlio f;
	
	public class Figlio {
		private int numero2;
		private String filgioClass;
		private Nipote n;
		
		public class Nipote {
			private int numero3;
			private String nipoteClass;
			
			
			public int getNumero3() {
				return numero3;
			}
			public void setNumero3(int numero3) {
				this.numero3 = numero3;
			}
			public String getNipoteClass() {
				return nipoteClass;
			}
			public void setNipoteClass(String nipoteClass) {
				this.nipoteClass = nipoteClass;
			}
			public String displayNumber() {
				return "padre numero:" + numero + " figlio numero:" + numero2 + " nipote numero:" + numero3 + " display:" + nipoteClass;
			}
			public String setFatherClass(String v) {
				return fatherClass = v;
			}
			
		}
		
		public int getNumero2() {
			return numero2;
		}
		public void setNumero2(int numero2) {
			this.numero2 = numero2;
		}
		public String getFilgioClass() {
			return filgioClass;
		}
		public void setFilgioClass(String filgioClass) {
			this.filgioClass = filgioClass;
		}
		
		public String displayNumber() {
			return "padre numero:" + numero + " figlio numero:" + numero2 + " display:" + filgioClass;
		}
		
		public Nipote setInstanceOfNipote() {
			n = new Nipote();
			return n;
		}
	}
	
	
	public String getFatherClass() {
		return fatherClass;
	}
	public void setFatherClass(String fatherClass) {
		this.fatherClass = fatherClass;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public Figlio setInstanceOfFiglio() {
		f = new Figlio();
		return f;
	}

}
