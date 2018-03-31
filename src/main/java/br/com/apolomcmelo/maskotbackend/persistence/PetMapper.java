package br.com.apolomcmelo.maskotbackend.persistence;

import java.util.List;

import br.com.apolomcmelo.maskotbackend.models.Pet;

public interface PetMapper {
	
	public void insertPet(Pet pet);
	
	public List<Pet> listPets();
	
	public Pet findPetById(Long id);
}