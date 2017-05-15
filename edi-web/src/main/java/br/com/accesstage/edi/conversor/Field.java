package br.com.accesstage.edi.conversor;

public class Field {

	private Integer addressEnd;
	private Integer addressInit;
	
	
	public Field(Integer addressInit, Integer addressEnd) {
		this.addressEnd = addressEnd;
		this.addressInit = addressInit;
	}
	/**
	 * @return the addressInit
	 */
	public Integer getAddressInit() {
		return addressInit;
	}
	/**
	 * @param addressInit the addressInit to set
	 */
	public void setAddressInit(Integer addressInit) {
		this.addressInit = addressInit;
	}
	/**
	 * @return the addressEnd
	 */
	public Integer getAddressEnd() {
		return addressEnd;
	}
	/**
	 * @param addressEnd the addressEnd to set
	 */
	public void setAddressEnd(Integer addressEnd) {
		this.addressEnd = addressEnd;
	}
	
}
