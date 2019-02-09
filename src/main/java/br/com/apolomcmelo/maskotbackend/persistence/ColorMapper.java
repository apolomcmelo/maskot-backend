package br.com.apolomcmelo.maskotbackend.persistence;

import java.util.List;

import br.com.apolomcmelo.maskotbackend.models.Color;

public interface ColorMapper {
	
	public void insertColor(Color color);
	
	public void updateColor(Color color);

	public List<Color> listColors();
	
	public Color findColorById(Long id);
}