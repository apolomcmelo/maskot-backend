package br.com.apolomcmelo.maskotbackend.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.apolomcmelo.maskotbackend.models.Pet;
import br.com.apolomcmelo.maskotbackend.persistence.PetMapper;

@Repository
public class PetDAO {
	
	@Autowired
	private PetMapper mapper;
	
	public boolean insertPet(Pet pet) {
		boolean success = true;
		
		try{
			mapper.insertPet(pet);			
		} catch (Exception e) {
			e.printStackTrace();
			success = false;
		}
		
		return success;
	}
	
	public List<Pet> listPets() {
		return mapper.listPets();
	}
	
	public Pet findPetById(Long id) {
		return mapper.findPetById(id);
	}
}