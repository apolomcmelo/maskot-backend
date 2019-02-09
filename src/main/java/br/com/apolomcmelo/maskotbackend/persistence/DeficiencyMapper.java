package br.com.apolomcmelo.maskotbackend.persistence;

import java.util.List;

import br.com.apolomcmelo.maskotbackend.models.Deficiency;

public interface DeficiencyMapper {
	
	public void insertDeficiency(Deficiency deficiency);
	
	public void updateDeficiency(Deficiency deficiency);

	public List<Deficiency> listDeficiencies();
	
	public Deficiency findDeficiencyById(Long id);
}