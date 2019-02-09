package br.com.apolomcmelo.maskotbackend.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import br.com.apolomcmelo.maskotbackend.converters.DeficiencyConverter;
import br.com.apolomcmelo.maskotbackend.daos.DeficiencyJpaDAO;
import br.com.apolomcmelo.maskotbackend.dtos.DeficiencyDTO;

@Service
@Transactional
public class DeficiencyBusiness {
	
	//TODO Remover esse dao assim que classe extender Business genérica
	@Autowired
	private DeficiencyJpaDAO dao;
	
	@Autowired
	private DeficiencyConverter converter;
	
	public boolean insertDeficiency(DeficiencyDTO deficiency) {
		if(ObjectUtils.isEmpty(deficiency)) {
			return false;
		}
		
		return deficiency.hasId() == false && dao.insertDeficiency(converter.convertToModel(deficiency));
	}
	
	public boolean updateDeficiency(DeficiencyDTO deficiency) {
		if(ObjectUtils.isEmpty(deficiency)) {
			return false;
		}
		
		return deficiency.hasId() == true && dao.updateDeficiency(converter.convertToModel(deficiency));
	}
	
	public List<DeficiencyDTO> listDeficiency() {
		return converter.convertListToDTO(dao.listDeficiencies());
	}
	
}