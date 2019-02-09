package br.com.apolomcmelo.maskotbackend.daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.apolomcmelo.maskotbackend.generics.JpaDAO;
import br.com.apolomcmelo.maskotbackend.models.Color;

@Repository
public class ColorJpaDAO extends JpaDAO<Long, Color> implements IColorDAO {

	@Override
	public boolean insertColor(Color color) {
		boolean success = true;
		
		try{
			super.insert(color);			
		} catch (Exception e) {
			e.printStackTrace();
			success = false;
		}
		
		return success;
	}

	@Override
	public boolean updateColor(Color color) {
		boolean success = true;
		
		try{
			super.update(color);			
		} catch (Exception e) {
			e.printStackTrace();
			success = false;
		}
		
		return success;
	}

	@Override
	public List<Color> listColors() {
		return super.list();
	}

	@Override
	public Color findColorById(Long id) {
		return super.getById(id);
	}

}