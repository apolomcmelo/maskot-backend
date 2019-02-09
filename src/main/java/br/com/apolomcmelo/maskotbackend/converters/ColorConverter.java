package br.com.apolomcmelo.maskotbackend.converters;

import java.util.List;

import br.com.apolomcmelo.maskotbackend.dtos.ColorDTO;
import br.com.apolomcmelo.maskotbackend.generics.Converter;
import br.com.apolomcmelo.maskotbackend.models.Color;

import com.google.common.collect.Lists;

public class ColorConverter implements Converter<Color, ColorDTO> {

	@Override
	public ColorDTO convertToDTO(Color model) {
		ColorDTO dto = ColorDTO.builder()
				.description(model.getDescription())
				.build();

		dto.setId(model.getId());
		
		return dto;
	}

	@Override
	public Color convertToModel(ColorDTO dto) {
		Color model = Color.builder()
						.id(dto.getId())
						.description(dto.getDescription()).build();

		return model;
	}

	@Override
	public List<ColorDTO> convertListToDTO(List<Color> listModel) {
		List<ColorDTO> listDto = Lists.newArrayList();

		if (listModel != null) {
			listModel.forEach(model -> listDto.add(this.convertToDTO(model)));
		}

		return listDto;
	}

	@Override
	public List<Color> convertListToModel(List<ColorDTO> listDto) {
		List<Color> listModel = Lists.newArrayList();

		if (listDto != null) {
			listDto.forEach(dto -> listModel.add(this.convertToModel(dto)));
		}

		return listModel;
	}

}
