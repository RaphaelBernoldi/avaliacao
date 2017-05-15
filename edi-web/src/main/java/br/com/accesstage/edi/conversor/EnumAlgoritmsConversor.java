package br.com.accesstage.edi.conversor;

public enum EnumAlgoritmsConversor {

	INSTITUITION_X("X", new ConversorInstituitionX());
	
	private String nameInstituition;
	private AbstractConversor algorithm;

	
	private EnumAlgoritmsConversor(String nameInstituition, AbstractConversor algorithm) {
		this.nameInstituition = nameInstituition;
		this.algorithm = algorithm;
	}
	/**
	 * @return the algorithm
	 */
	public AbstractConversor getAlgorithm() {
		return algorithm;
	}
	
	/**
	 * @return the nameInstituition
	 */
	public String getNameInstituition() {
		return nameInstituition;
	}
	
	public static EnumAlgoritmsConversor loadByName(String name){
		for (EnumAlgoritmsConversor algoritmsConversor : values()) {
			if(name.toLowerCase().equals(algoritmsConversor.nameInstituition.toLowerCase())){
				return algoritmsConversor;
			}
		}
		throw new IllegalArgumentException("Instituition not found");
	}
}
