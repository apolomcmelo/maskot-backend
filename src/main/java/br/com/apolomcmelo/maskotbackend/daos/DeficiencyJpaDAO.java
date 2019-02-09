package br.com.apolomcmelo.maskotbackend.daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.apolomcmelo.maskotbackend.generics.JpaDAO;
import br.com.apolomcmelo.maskotbackend.models.Deficiency;

@Repository
public class DeficiencyJpaDAO extends JpaDAO<Long, Deficiency> implements IDeficiencyDAO {

	@Override
	public boolean insertDeficiency(Deficiency deficiency) {
		boolean success = true;
		
		try{
			super.insert(deficiency);			
		} catch (Exception e) {
			e.printStackTrace();
			success = false;
		}
		
		return success;
	}

	@Override
	public boolean updateDeficiency(Deficiency deficiency) {
		boolean success = true;
		
		try{
			super.update(deficiency);			
		} catch (Exception e) {
			e.printStackTrace();
			success = false;
		}
		
		return success;
	}

	@Override
	public List<Deficiency> listDeficiencies() {
		return super.list();
	}

	@Override
	public Deficiency findDeficiencyById(Long id) {
		return super.getById(id);
	}

}