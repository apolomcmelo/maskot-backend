package br.com.apolomcmelo.maskotbackend.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import br.com.apolomcmelo.maskotbackend.enums.Size;
import br.com.apolomcmelo.maskotbackend.generics.DTO;

@Data
@Builder
@EqualsAndHashCode(callSuper=false)
public class BreedDTO extends DTO {
	
	private String name;
	private String description;
	private Size size;
}