package br.com.apolomcmelo.maskotbackend.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import br.com.apolomcmelo.maskotbackend.converters.BreedConverter;
import br.com.apolomcmelo.maskotbackend.daos.BreedJpaDAO;
import br.com.apolomcmelo.maskotbackend.dtos.BreedDTO;

@Service
@Transactional
public class BreedBusiness {
	
	//TODO Remover esse dao assim que classe extender Business genérica
	@Autowired
	private BreedJpaDAO dao;
	
	@Autowired
	private BreedConverter converter;
	
	public boolean insertBreed(BreedDTO breed) {
		if(ObjectUtils.isEmpty(breed)) {
			return false;
		}
		
		return breed.hasId() == false && dao.insertBreed(converter.convertToModel(breed));
	}
	
	public boolean updateBreed(BreedDTO breed) {
		if(ObjectUtils.isEmpty(breed)) {
			return false;
		}
		
		return breed.hasId() == true && dao.updateBreed(converter.convertToModel(breed));
	}
	
	public List<BreedDTO> listBreed() {
		return converter.convertListToDTO(dao.listBreeds());
	}
	
}