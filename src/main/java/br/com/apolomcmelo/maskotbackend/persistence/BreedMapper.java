package br.com.apolomcmelo.maskotbackend.persistence;

import java.util.List;

import br.com.apolomcmelo.maskotbackend.models.Breed;

public interface BreedMapper {
	
	public void insertBreed(Breed breed);
	
	public void updateBreed(Breed breed);

	public List<Breed> listBreeds();
	
	public Breed findBreedById(Long id);
}