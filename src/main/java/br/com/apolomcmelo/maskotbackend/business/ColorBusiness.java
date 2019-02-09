package br.com.apolomcmelo.maskotbackend.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import br.com.apolomcmelo.maskotbackend.converters.ColorConverter;
import br.com.apolomcmelo.maskotbackend.daos.ColorJpaDAO;
import br.com.apolomcmelo.maskotbackend.dtos.ColorDTO;

@Service
@Transactional
public class ColorBusiness {
	
	//TODO Remover esse dao assim que classe extender Business genérica
	@Autowired
	private ColorJpaDAO dao;
	
	@Autowired
	private ColorConverter converter;
	
	public boolean insertColor(ColorDTO color) {
		if(ObjectUtils.isEmpty(color)) {
			return false;
		}
		
		return color.hasId() == false && dao.insertColor(converter.convertToModel(color));
	}
	
	public boolean updateColor(ColorDTO color) {
		if(ObjectUtils.isEmpty(color)) {
			return false;
		}
		
		return color.hasId() == true && dao.updateColor(converter.convertToModel(color));
	}
	
	public List<ColorDTO> listColor() {
		return converter.convertListToDTO(dao.listColors());
	}
	
}