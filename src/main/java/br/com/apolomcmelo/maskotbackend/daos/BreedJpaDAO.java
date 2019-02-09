package br.com.apolomcmelo.maskotbackend.daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.apolomcmelo.maskotbackend.generics.JpaDAO;
import br.com.apolomcmelo.maskotbackend.models.Breed;

@Repository
public class BreedJpaDAO extends JpaDAO<Long, Breed> implements IBreedDAO {

	@Override
	public boolean insertBreed(Breed breed) {
		boolean success = true;
		
		try{
			super.insert(breed);			
		} catch (Exception e) {
			e.printStackTrace();
			success = false;
		}
		
		return success;
	}

	@Override
	public boolean updateBreed(Breed breed) {
		boolean success = true;
		
		try{
			super.update(breed);			
		} catch (Exception e) {
			e.printStackTrace();
			success = false;
		}
		
		return success;
	}

	@Override
	public List<Breed> listBreeds() {
		return super.list();
	}

	@Override
	public Breed findBreedById(Long id) {
		return super.getById(id);
	}

}