package br.com.accesstage.edi.conversor;

public enum EnumField {
	TYPE_TRANSACTION(0, 3), 
	AGENCY(3, 7), 
	ACCOUNT(7, 12), 
	DIGIT_ACCOUNT(12, 13), 
	NAME_FAVORED(13, 43), 
	CPF(43,	54), 
	VALUE_TRANSACTION(54, 59), 
	VALUE_TRANSACTION_DECIMAL(59, 61),
	DATE_TRANSACTION(61, 69);

	private Integer addressEnd;
	private Integer addressInit;

	private EnumField(Integer addressInit, Integer addressEnd) {
		this.addressEnd = addressEnd;
		this.addressInit = addressInit;
	}

	/**
	 * @return the addressEnd
	 */
	public Integer getAddressEnd() {
		return addressEnd;
	}

	/**
	 * @return the addressInit
	 */
	public Integer getAddressInit() {
		return addressInit;
	}
	
	
}
