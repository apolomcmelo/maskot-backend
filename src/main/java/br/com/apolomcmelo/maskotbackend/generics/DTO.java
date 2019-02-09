package br.com.apolomcmelo.maskotbackend.generics;

import lombok.Getter;
import lombok.Setter;

public abstract class DTO {
	
	@Setter
	@Getter
	private Long id;
	
	public boolean hasId() {
		return this.id != null && this.id > 0x0L;
	}
}
