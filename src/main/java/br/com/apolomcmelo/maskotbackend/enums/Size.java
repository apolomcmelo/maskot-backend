package br.com.apolomcmelo.maskotbackend.enums;


public enum Size {
	SMALL("Pequeno"),
	MID("Médio"),
	BIG("Grande"),
	GIANT("Gigante");
	
	private String description;
	
	private Size(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public static Size getSizeByDescripton(String description) {
		for (Size size : Size.values()) {
			if(description != null && size.getDescription().equals(description)) {
				return size;
			}
		}
		
		return null;
	}
}