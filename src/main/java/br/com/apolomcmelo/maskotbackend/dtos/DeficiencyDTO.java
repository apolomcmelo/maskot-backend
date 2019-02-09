package br.com.apolomcmelo.maskotbackend.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import br.com.apolomcmelo.maskotbackend.generics.DTO;

@Data
@Builder
@EqualsAndHashCode(callSuper=false)
public class DeficiencyDTO extends DTO {
	
	private String description;
}