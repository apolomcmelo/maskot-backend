package br.com.apolomcmelo.maskotbackend.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.apolomcmelo.maskotbackend.generics.DAO;
import br.com.apolomcmelo.maskotbackend.models.Color;
import br.com.apolomcmelo.maskotbackend.persistence.ColorMapper;

@Repository
public class ColorDAO extends DAO implements IColorDAO {
	
	@Autowired
	private ColorMapper mapper;
	
	public boolean insertColor(Color color) {
		boolean success = true;
		
		try{
			mapper.insertColor(color);			
		} catch (Exception e) {
			e.printStackTrace();
			success = false;
		}
		
		return success;
	}
	
	public boolean updateColor(Color color) {
		boolean success = true;
		
		try{
			mapper.updateColor(color);			
		} catch (Exception e) {
			e.printStackTrace();
			success = false;
		}
		
		return success;
	}
	
	public List<Color> listColors() {
		return mapper.listColors();
	}
	
	public Color findColorById(Long id) {
		return mapper.findColorById(id);
	}
}