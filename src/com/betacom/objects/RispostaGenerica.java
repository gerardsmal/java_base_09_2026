package com.betacom.objects;

import java.util.List;

public class RispostaGenerica <T , U>{

	private boolean rc;
	private U other;
	private List<T>   data;
	
	
	public boolean isRc() {
		return rc;
	}
	public void setRc(boolean rc) {
		this.rc = rc;
	}
	public U getOther() {
		return other;
	}
	public void setOther(U other) {
		this.other = other;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "RispostaGenerica [rc=" + rc + ", other=" + other + ", data=" + data + "]";
	}

}
