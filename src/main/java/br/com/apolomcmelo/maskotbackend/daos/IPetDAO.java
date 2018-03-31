package br.com.apolomcmelo.maskotbackend.daos;

import java.util.List;

import br.com.apolomcmelo.maskotbackend.models.Pet;

public interface IPetDAO {
	boolean insertPet(Pet pet);
	
	boolean updatePet(Pet pet);

	List<Pet> listPets();
	
	Pet findPetById(Long id);
}