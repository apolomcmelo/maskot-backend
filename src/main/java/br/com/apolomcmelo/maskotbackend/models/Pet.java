package br.com.apolomcmelo.maskotbackend.models;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
import br.com.apolomcmelo.maskotbackend.enums.Size;
import br.com.apolomcmelo.maskotbackend.enums.Species;

@Data
public class Pet {
	private Long id;
	private String name;
	private String profilePicture; // Endereço da imagem
	private List<String> pictures; // Endereço das imagens
	private Species species;
	private Breed breed;
	private Size size;
	private Color dominantColor;
	private List<Deficiency> deficiencies;
	private Boolean neutered;
	private Integer stage;
	
	private String lastLocation;
	private LocalDateTime lastTimeSeen;
	private Boolean withOwner;
	
}