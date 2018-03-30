package br.com.apolomcmelo.maskotbackend.enums;

public enum Gender {
	MALE("Macho"),
	FEMALE("Fêmea"),
	UNKNOWN("Desconhecido");
	
	private String description;
	
	private Gender(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public static Gender getGenderByDescripton(String description) {
		for (Gender gender : Gender.values()) {
			if(description != null && gender.getDescription().equals(description)) {
				return gender;
			}
		}
		
		return null;
	}
}