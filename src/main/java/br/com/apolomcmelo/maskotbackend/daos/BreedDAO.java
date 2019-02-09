package br.com.apolomcmelo.maskotbackend.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.apolomcmelo.maskotbackend.generics.DAO;
import br.com.apolomcmelo.maskotbackend.models.Breed;
import br.com.apolomcmelo.maskotbackend.persistence.BreedMapper;

@Repository
public class BreedDAO extends DAO implements IBreedDAO {
	
	@Autowired
	private BreedMapper mapper;
	
	public boolean insertBreed(Breed breed) {
		boolean success = true;
		
		try{
			mapper.insertBreed(breed);			
		} catch (Exception e) {
			e.printStackTrace();
			success = false;
		}
		
		return success;
	}
	
	public boolean updateBreed(Breed breed) {
		boolean success = true;
		
		try{
			mapper.updateBreed(breed);			
		} catch (Exception e) {
			e.printStackTrace();
			success = false;
		}
		
		return success;
	}
	
	public List<Breed> listBreeds() {
		return mapper.listBreeds();
	}
	
	public Breed findBreedById(Long id) {
		return mapper.findBreedById(id);
	}
}