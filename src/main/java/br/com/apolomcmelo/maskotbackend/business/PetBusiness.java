package br.com.apolomcmelo.maskotbackend.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import br.com.apolomcmelo.maskotbackend.converters.PetConverter;
import br.com.apolomcmelo.maskotbackend.daos.PetJpaDAO;
import br.com.apolomcmelo.maskotbackend.dtos.PetDTO;

@Service
@Transactional
public class PetBusiness {
	
	//TODO Remover esse dao assim que classe extender Business genérica
	@Autowired
	private PetJpaDAO dao;
	
	@Autowired
	private PetConverter converter;
	
	public boolean insertPet(PetDTO pet) {
		if(ObjectUtils.isEmpty(pet)) {
			return false;
		}
		
		return pet.hasId() == false && dao.insertPet(converter.convertToModel(pet));
	}
	
	public boolean updatePet(PetDTO pet) {
		if(ObjectUtils.isEmpty(pet)) {
			return false;
		}
		
		return pet.hasId() == true && dao.updatePet(converter.convertToModel(pet));
	}
	
	public List<PetDTO> listPet() {
		return converter.convertListToDTO(dao.listPets());
	}
	
}