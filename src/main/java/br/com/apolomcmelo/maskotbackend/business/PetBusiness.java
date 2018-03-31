package br.com.apolomcmelo.maskotbackend.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import br.com.apolomcmelo.maskotbackend.daos.PetJpaDAO;
import br.com.apolomcmelo.maskotbackend.models.Pet;

@Service
public class PetBusiness {
	
	//TODO Remover esse dao assim que classe extender Business genérica
	@Autowired
	private PetJpaDAO dao;
	
	public boolean insertPet(Pet pet) {
		if(ObjectUtils.isEmpty(pet)) {
			return false;
		}
		
		return pet.hasId() == false && dao.insertPet(pet);
	}
	
	public boolean updatePet(Pet pet) {
		if(ObjectUtils.isEmpty(pet)) {
			return false;
		}
		
		return pet.hasId() == true && dao.updatePet(pet);
	}
	
}