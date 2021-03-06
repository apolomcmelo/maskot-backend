package br.com.apolomcmelo.maskotbackend.daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.apolomcmelo.maskotbackend.generics.JpaDAO;
import br.com.apolomcmelo.maskotbackend.models.Pet;

@Repository
public class PetJpaDAO extends JpaDAO<Long, Pet> implements IPetDAO {

	@Override
	public boolean insertPet(Pet pet) {
		boolean success = true;
		
		try{
			super.insert(pet);			
		} catch (Exception e) {
			e.printStackTrace();
			success = false;
		}
		
		return success;
	}

	@Override
	public boolean updatePet(Pet pet) {
		boolean success = true;
		
		try{
			super.update(pet);			
		} catch (Exception e) {
			e.printStackTrace();
			success = false;
		}
		
		return success;
	}

	@Override
	public List<Pet> listPets() {
		return super.list();
	}

	@Override
	public Pet findPetById(Long id) {
		return super.getById(id);
	}

}