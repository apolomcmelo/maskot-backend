package br.com.apolomcmelo.maskotbackend.daos;

import java.util.List;

import br.com.apolomcmelo.maskotbackend.models.Breed;

public interface IBreedDAO {
	boolean insertBreed(Breed breed);
	
	boolean updateBreed(Breed breed);

	List<Breed> listBreeds();
	
	Breed findBreedById(Long id);
}