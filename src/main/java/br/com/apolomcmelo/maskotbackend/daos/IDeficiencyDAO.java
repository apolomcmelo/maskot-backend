package br.com.apolomcmelo.maskotbackend.daos;

import java.util.List;

import br.com.apolomcmelo.maskotbackend.models.Deficiency;

public interface IDeficiencyDAO {
	boolean insertDeficiency(Deficiency deficiency);
	
	boolean updateDeficiency(Deficiency deficiency);

	List<Deficiency> listDeficiencies();
	
	Deficiency findDeficiencyById(Long id);
}