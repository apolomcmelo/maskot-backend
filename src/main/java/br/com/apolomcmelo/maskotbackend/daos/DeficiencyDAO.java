package br.com.apolomcmelo.maskotbackend.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.apolomcmelo.maskotbackend.generics.DAO;
import br.com.apolomcmelo.maskotbackend.models.Deficiency;
import br.com.apolomcmelo.maskotbackend.persistence.DeficiencyMapper;

@Repository
public class DeficiencyDAO extends DAO implements IDeficiencyDAO {
	
	@Autowired
	private DeficiencyMapper mapper;
	
	public boolean insertDeficiency(Deficiency deficiency) {
		boolean success = true;
		
		try{
			mapper.insertDeficiency(deficiency);			
		} catch (Exception e) {
			e.printStackTrace();
			success = false;
		}
		
		return success;
	}
	
	public boolean updateDeficiency(Deficiency deficiency) {
		boolean success = true;
		
		try{
			mapper.updateDeficiency(deficiency);			
		} catch (Exception e) {
			e.printStackTrace();
			success = false;
		}
		
		return success;
	}
	
	public List<Deficiency> listDeficiencies() {
		return mapper.listDeficiencies();
	}
	
	public Deficiency findDeficiencyById(Long id) {
		return mapper.findDeficiencyById(id);
	}
}