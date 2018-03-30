package br.com.apolomcmelo.maskotbackend.enums;

public enum Species {
	CAT("Gato"),
	DOG("Cachorro");

	private String description;
	
	private Species(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public static Species getSpeciesByDescripton(String description) {
		for (Species species : Species.values()) {
			if(description != null && species.getDescription().equals(description)) {
				return species;
			}
		}
		
		return null;
	}
}