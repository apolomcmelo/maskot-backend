package br.com.apolomcmelo.maskotbackend.dtos;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import br.com.apolomcmelo.maskotbackend.enums.Species;
import br.com.apolomcmelo.maskotbackend.generics.DTO;

@Data
@Builder
@EqualsAndHashCode(callSuper=false)
public class PetDTO extends DTO {
	
	private String name;
	private String profilePicture; // Endereço da imagem
	private List<String> pictures; // Endereço das imagens
	private Species species;
	private BreedDTO breed;
	private ColorDTO color;
	private List<DeficiencyDTO> deficiencies;
	private Boolean neutered;
	private Integer age;
	private String lastLocation;
	private Date lastTimeSeen;
	private Boolean withOwner;
	
}