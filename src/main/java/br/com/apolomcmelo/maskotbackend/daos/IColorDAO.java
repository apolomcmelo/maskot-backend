package br.com.apolomcmelo.maskotbackend.daos;

import java.util.List;

import br.com.apolomcmelo.maskotbackend.models.Color;

public interface IColorDAO {
	boolean insertColor(Color color);
	
	boolean updateColor(Color color);

	List<Color> listColors();
	
	Color findColorById(Long id);
}